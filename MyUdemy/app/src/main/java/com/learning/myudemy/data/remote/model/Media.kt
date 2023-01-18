package com.learning.myudemy.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Media(
    @Json(name = "course_image")
    val courseImage: CourseImage,
    @Json(name = "course_video")
    val courseVideo: CourseVideo,
    @Json(name = "image")
    val image: Image
)