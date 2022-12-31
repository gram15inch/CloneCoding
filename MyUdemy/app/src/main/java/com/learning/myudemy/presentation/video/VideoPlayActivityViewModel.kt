package com.learning.myudemy.presentation.video

import androidx.lifecycle.ViewModel
import com.google.android.exoplayer2.SimpleExoPlayer
import com.learning.myudemy.UdemyApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class VideoPlayActivityViewModel : ViewModel() {
    var player: SimpleExoPlayer? = null
    var playWhenReady = false
    var currentWindow = 0
    var playbackPosition = 0L

    var url = 0
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