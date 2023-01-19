package com.learning.myudemy.presentation.model

enum class BannerTag { Image, Intro, Partner }
data class UiBanner(val tag: BannerTag, val url: String? = null)
