package com.learning.myudemy.presentation.model


enum class RecommendTag{ Lecture, Category, Banner }
data class UiRecommend(val tag:RecommendTag,val title:String, val lectures:List<UiLecture>, val categories: List<UiCategory>)

data class UiLecture(val id:Int)

data class UiCategory (val title:String )