package com.learning.myudemy.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CourseVideo(
    @Json(name = "uri")
    val uri: Any?
)