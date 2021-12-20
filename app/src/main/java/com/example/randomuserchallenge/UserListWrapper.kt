package com.example.randomuserchallenge

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import okio.BufferedSource

@JsonClass(generateAdapter = true)
data class UserListWrapper(@Json(name = "data") val list: List<User>) {
    companion object {
        fun processJSONtoList(downloadedData: BufferedSource): List<User> {
            val adapter = MoshiHelper.moshi.adapter(UserListWrapper::class.java)
            val guideList = adapter.fromJson(downloadedData)!!.list
            return guideList!!
        }
    }
}
