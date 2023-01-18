package com.learning.myudemy.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pagination(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "num_pages")
    val numPages: Int,
    @Json(name = "previous")
    val previous: Any?
)