package com.learning.myudemy.domain.model

import androidx.recyclerview.widget.DiffUtil

data class Lecture (
    val lectureId :Int,
    val lectureName :String,
    val Instructor: String,
    val gradeScore: Float,
    val gradeCount:Int,
    val lecturePrice:Int,
    val lectureThumbnail:Int,
    val isBestSeller:Boolean){

}
