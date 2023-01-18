package com.learning.myudemy.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TestData(
    @Json(name = "pagination")
    val pagination: Pagination,
    @Json(name = "results")
    val results: List<Result>
)