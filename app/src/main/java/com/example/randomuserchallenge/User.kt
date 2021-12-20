package com.example.randomuserchallenge



import android.graphics.Picture
import android.location.Location
import com.squareup.moshi.JsonClass
import java.util.jar.Attributes


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
    val nat: String)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class LocationData(
    val street: String,
    val city: String,
    val state: String,
    val postcode: String,
    val coordinates: Coordinates,
    val timezone: Timezone
)

data class Coordinates(
    val latitude: String,
    val longitude: String
)

data class Timezone(
    val offset: String,
    val description: String
)

data class Date(
    val date: String,
    val age: String
)

data class Login(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)

data class ID(
    val name: String,
    val value: String
)

data class PictureData(
    val large: String,
    val medium: String,
    val thumbnail: String
)