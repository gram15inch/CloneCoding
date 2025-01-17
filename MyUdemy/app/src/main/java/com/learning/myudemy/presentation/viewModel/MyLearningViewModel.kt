package com.learning.myudemy.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.learning.myudemy.domain.repository.CategoryRepository
import com.learning.myudemy.domain.repository.LectureRepository
import com.learning.myudemy.presentation.base.ErrorHandleViewModel
import com.learning.myudemy.presentation.converter.UiConverter
import com.learning.myudemy.presentation.model.UiMyLeaningLecture
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyLearningViewModel @Inject constructor(
    private val lectureRepository: LectureRepository,
    private val categoryRepository: CategoryRepository
) : ErrorHandleViewModel() {

    private val _lecturesFlow = MutableStateFlow<List<UiMyLeaningLecture>>(emptyList())
    val lecturesLive get() = _lecturesFlow.asLiveData()

    init {
        // refreshUiMyLeaningLecturedWithCategory()
        refreshUiMyLeaningLecturedWithErrorHandle()

    }

    private fun refreshUiMyLeaningLecturedWithCategory() {
        viewModelScope.launch {
            categoryRepository
                .getCategoryList()
                .map { category ->
                    lectureRepository
                        .getLectureListWithApi(category.id)
                        .first()
                        .run { UiConverter.toUiMyLeaningLecture(this) }
                }.also {
                    _lecturesFlow.emit(it)
                }
        }
    }

    private fun refreshUiMyLeaningLecturedWithErrorHandle() {
        viewModelScope.launch(exceptionHandler) {
            lectureRepository
                .getLectureListWithApiResponse(1)
                .map {
                    UiConverter.toUiMyLeaningLecture(it)
                }.apply {
                    _lecturesFlow.emit(this)
                }
        }
    }
    private fun refreshUiMyLeaningLecturedWithCall() {
        viewModelScope.launch {
            //lectureRepository.getLectureListWithApiCall(1)
        }
    }


    /* 리소스 에서 가져올때 사용 */
    @Deprecated("리소스 에서 가져올때 사용")
    val lectureListRes = MutableLiveData<List<UiMyLeaningLecture>>()

    private fun lectureUpdate() {
        viewModelScope.launch {
            lectureListRes.value =
                lectureRepository.getLectureListWithRes(4)
                    .map { UiConverter.toUiMyLeaningLecture(it) }
        }
    }

    fun updateLectures(list: List<UiMyLeaningLecture>) {
        lectureListRes.value = list
    }
}