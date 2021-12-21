package com.example.randomuserchallenge

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val gender: String,
    val name: Name,
    val location: LocationData,
    val email: String,
    val login: Login,
    val dob: Date,
    val registered: Date,
    val phone: String,
    val cell: String,
    val id: ID,
    val picture: PictureData,
    val nat: String
)

@JsonClass(generateAdapter = true)
data class Name(
    val title: String,
    val first: String,
    val last: String
)

@JsonClass(generateAdapter = true)
data class LocationData(
    val street: Street,
    val city: String,
    val state: String,
    val postcode: String,
    val coordinates: Coordinates,
    val timezone: Timezone
)

@JsonClass(generateAdapter = true)
data class Street(
    val number: String,
    val name: String
)

@JsonClass(generateAdapter = true)
data class Coordinates(
    val latitude: String,
    val longitude: String
)

@JsonClass(generateAdapter = true)
data class Timezone(
    val offset: String,
    val description: String
)

@JsonClass(generateAdapter = true)
data class Date(
    val date: String,
    val age: String
)

@JsonClass(generateAdapter = true)
data class Login(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)

@JsonClass(generateAdapter = true)
data class ID(
    val name: String,
    val value: String? = null
)

@JsonClass(generateAdapter = true)
data class PictureData(
    val large: String,
    val medium: String,
    val thumbnail: String
)