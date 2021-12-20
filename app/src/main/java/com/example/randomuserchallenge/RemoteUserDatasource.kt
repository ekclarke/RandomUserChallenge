package com.example.randomuserchallenge

import android.util.Log
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.security.InvalidParameterException

class RemoteUserDatasource {
    private val TAG = "RemoteUserDatasource"

    fun getFromURL(url: String, callback: Callback){
        Log.d(TAG, "getFromURL called")
        //TODO: More elegant error handling.
        if (url=="") {
            throw InvalidParameterException("No URL passed.")
        }
        else {
            var client = OkHttpClient()
            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            client = client.newBuilder().addInterceptor(logging).build()
            val request = Request.Builder().url(url).build()
            client.newCall(request).enqueue(callback)
        }
    }
}