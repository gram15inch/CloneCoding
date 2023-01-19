package com.learning.myudemy.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.learning.myudemy.domain.repository.LectureRepository
import com.learning.myudemy.presentation.converter.UiConverter
import com.learning.myudemy.presentation.model.UiMyLeaningLecture
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyLearningViewModel @Inject constructor(private val lectureRepository: LectureRepository) :
    ViewModel() {
    val lectures = MutableLiveData<List<UiMyLeaningLecture>>()
    private val _lecturesFlow = MutableStateFlow<List<UiMyLeaningLecture>>(emptyList())
    val lecturesLive get() = _lecturesFlow.asLiveData()

    init {
        viewModelScope.launch {
            lectureRepository.lectureList.collect { list ->
                list.map {
                    UiConverter.toUiMyLeaningLecture(it)
                }.run { _lecturesFlow.emit(this) }
            }
        }
    }

    init {
        //lectureUpdate()
        viewModelRefresh()
    }

    private fun viewModelRefresh() {
        viewModelScope.launch {
            lectureRepository.refreshCache()
        }
    }



    private fun lectureUpdate() {
        viewModelScope.launch {
            lectures.value =
                lectureRepository.getLectureListWithRes(4)
                    .map { UiConverter.toUiMyLeaningLecture(it) }
        }
    }
    fun updateLectures(list: List<UiMyLeaningLecture>) {
        lectures.value = list
    }
}