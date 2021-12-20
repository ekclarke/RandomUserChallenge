package com.example.randomuserchallenge

import com.squareup.moshi.Moshi

object MoshiHelper {
    lateinit var moshi: Moshi

    fun buildMoshi() {
        moshi = Moshi.Builder().build()
    }
}