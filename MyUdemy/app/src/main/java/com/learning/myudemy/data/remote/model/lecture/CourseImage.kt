package com.learning.myudemy.data.remote.model.lecture


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CourseImage(
    @Json(name = "uri")
    val uri: String
)