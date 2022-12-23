package com.learning.myudemy.ui.recommendation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class RecommendationViewModel @Inject constructor() : ViewModel() {
    var count =0
    val str ="RecommendationViewModel"

    fun countUp(){
        count++
    }
}