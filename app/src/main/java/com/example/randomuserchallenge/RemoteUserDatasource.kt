package com.example.randomuserchallenge

import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.security.InvalidParameterException

class RemoteUserDatasource {

    fun getFromURL(url: String, callback: Callback) {
        if (url == "") {
            throw InvalidParameterException("No URL passed.")
        } else {
            var client = OkHttpClient()
            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            client = client.newBuilder().addInterceptor(logging).build()
            val request = Request.Builder().url(url).build()
            client.newCall(request).enqueue(callback)
        }
    }
}