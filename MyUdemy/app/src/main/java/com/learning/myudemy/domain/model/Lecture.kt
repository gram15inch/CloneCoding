package com.learning.myudemy.domain.model

data class Lecture(
    val lectureId: Int,
    val lectureName: String,
    val Instructor: String,
    val gradeScore: Float,
    val gradeCount: Int,
    val lecturePrice: Int,
    val lectureThumbnailRes: Int,
    val lectureThumbnailUrl: String,
    val isBestSeller: Boolean
){

}
