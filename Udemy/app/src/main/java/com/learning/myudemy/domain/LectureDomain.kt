package com.learning.myudemy.domain

data class LectureDomain (
    val lectureId :Int,
    val lectureName :String,
    val Instructor: String,
    val gradeScore: Float,
    val gradeCount:Int,
    val lecturePrice:Int,
    val isBestSeller:Boolean
        )