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
