package com.example.randomuserchallenge

import okhttp3.Call
import okhttp3.Response
import java.io.IOException

class UserRepository {

    interface Callback {
        fun onComplete(pulledList: List<User>)
    }

    fun getUsers(url: String, callback: Callback) {
        val getRawData = RemoteUserDatasource()
        val httpCallback = object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unsuccessful response.")
                callback.onComplete(UserListWrapper.processJSONtoList(response.body!!.source()))
                response.close()
            }
        }
        getRawData.getFromURL(url, httpCallback)
    }
}