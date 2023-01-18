package com.learning.myudemy.data.remote.model.lecture


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "large")
    val large: String,
    @Json(name = "raw")
    val raw: String,
    @Json(name = "small")
    val small: String
)