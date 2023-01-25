package com.learning.myudemy.domain.model.test

sealed class TestSealColor

data class Red(val r: Int, val g: Int, val b: Int) : TestSealColor()
data class Orange(val r: Int, val g: Int, val b: Int) : TestSealColor()
data class Yellow(val r: Int, val g: Int, val b: Int) : TestSealColor()
