package com.learning.myudemy.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.google.android.exoplayer2.SimpleExoPlayer
import com.learning.myudemy.UdemyApplication
import com.learning.myudemy.domain.repository.LectureRepository
import com.learning.myudemy.presentation.converter.UiConverter
import com.learning.myudemy.presentation.model.UiLecture
import com.learning.myudemy.presentation.model.UiMyLeaningLecture
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class VideoPlayViewModel @Inject constructor(private val lectureRepository: LectureRepository) :
    ViewModel() {
    var player: SimpleExoPlayer? = null
    var playWhenReady = false
    var currentWindow = 0
    var playbackPosition = 0L

    private val _lecturesFlow = MutableStateFlow<List<UiLecture>>(emptyList())
    val lecturesLive get() = _lecturesFlow.asLiveData()

    val lectureTitle  = MutableLiveData<String>()
    val lectureSubTitle  = MutableLiveData<String>()
    val lectureSection  = MutableLiveData<String>()
    var urlRes = 0


    init {
        // refreshUiMyLeaningLecture()
        viewModelScope.launch {
            _lecturesFlow.collect{
                if(it.isNotEmpty()){
                    lectureTitle.value = it[0].lectureName
                    lectureSubTitle.value = it[0].Instructor
                    lectureSection.value = it[0].classfyName
                }
            }
        }

    }

    fun refreshUiMyLeaningLecture(id: Int) {
        viewModelScope.launch {
            lectureRepository
                .getLectureListWithApi(id)
                .map { UiConverter.toUiLecture(it) }
                .apply { _lecturesFlow.emit(this) }
        }
    }


    fun checkBackgroundPlay(): Boolean {
        return true
    }

    fun refreshVideoState() {
        with(UdemyApplication.prefs) {
            playWhenReady = getString("playWhenReady", "false").toBoolean()
            currentWindow = getString("currentWindow", "0").toInt()
            playbackPosition = getString("playbackPosition", "0").toLong()
            Timber.d("videoState: $playWhenReady, $currentWindow, $playbackPosition ")
        }
    }

    fun storeVideoState() {
        with(UdemyApplication.prefs) {
            setString("playWhenReady", "$playWhenReady")
            setString("currentWindow", "$currentWindow")
            setString("playbackPosition", "$playbackPosition")
            Timber.d("videoState: $playWhenReady, $currentWindow, $playbackPosition ")
        }


    }

}