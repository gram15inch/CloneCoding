package com.learning.myudemy.data.remote.model.lecture


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LectureResponse(
    @Json(name = "pagination")
    val pagination: Pagination,
    @Json(name = "results")
    val remoteLectures: List<RemoteLecture>
)