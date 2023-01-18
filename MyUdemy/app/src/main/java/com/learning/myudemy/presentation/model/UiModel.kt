package com.learning.myudemy.presentation.model


enum class RecommendTag { Lecture, Category, Banner }
data class UiRecommend(
    val tag: RecommendTag,
    val id: Int,
    val title: String? = null,
    val lectures: List<UiLecture>? = null,
    val categories: List<UiCategory>? = null,
    val banner: UiBanner? = null
)

data class UiLecture(
    val lectureId: Int,
    val lectureName: String,
    val Instructor: String,
    val gradeScore: Float,
    val gradeCount: Int,
    val lecturePrice: Int,
    val lectureThumbnail: Int,
    val isBestSeller: Boolean
)

data class UiCategory(val id: Int, val name: String)

enum class BannerTag { Image, Intro, Partner }
data class UiBanner(val tag: BannerTag, val url: String? = null)

data class UiMyLeaningLecture(
    val id: Int,
    val title: String,
    val subTitle: String,
    val imgRes: Int,
    val imgUrl: String,
    var isChecked: Boolean
)