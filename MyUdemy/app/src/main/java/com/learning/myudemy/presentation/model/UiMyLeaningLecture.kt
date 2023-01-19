package com.learning.myudemy.presentation.model

data class UiMyLeaningLecture(
    val id: Int,
    val title: String,
    val subTitle: String,
    val imgRes: Int,
    val imgUrl: String,
    val classfyCode: String,
    val classfyName: String,
    var isChecked: Boolean
)