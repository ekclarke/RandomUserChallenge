package com.example.randomuserchallenge

import android.util.Log
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

class UserRepository {
    private val TAG = "UserRepository"

interface Callback {
    fun onComplete(pulledList: List<User>)
}

fun getUsers(url: String, callback: Callback){
    Log.d(TAG, "getUsers called")
    val getRawData = RemoteUserDatasource()
    val httpCallback = object : okhttp3.Callback{
        override fun onFailure(call: Call, e: IOException){
            e.printStackTrace()
            //TODO: implement more elegant error handling. Toast?
        }

        override fun onResponse(call: Call, response: Response){
            //TODO: implement more elegant error handing. Better info on unsuccessful response?
            if (!response.isSuccessful) throw IOException("Unsuccessful response.")
            callback.onComplete(UserListWrapper.processJSONtoList(response.body!!.source()))
            response.close()
        }
    }
    getRawData.getFromURL(url, httpCallback)
}
}