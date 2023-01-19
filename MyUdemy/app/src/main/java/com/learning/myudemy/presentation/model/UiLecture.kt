package com.learning.myudemy.presentation.model

data class UiLecture(
    val lectureId: Int,
    val lectureName: String,
    val Instructor: String,
    val classfyCode: String,
    val classfyName: String,
    val gradeScore: Float,
    val gradeCount: Int,
    val lecturePrice: Int,
    val videoTime: String,
    val lectureThumbnailRes: Int,
    val lectureThumbnailUrl: String,
    val isBestSeller: Boolean
)
