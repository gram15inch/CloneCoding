package com.learning.myudemy.presentation.video

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.learning.myudemy.R
import com.learning.myudemy.databinding.ActivityVideoPlayBinding
import com.learning.myudemy.presentation.base.LifecycleActivity

class VideoPlayActivity : LifecycleActivity() {
    lateinit var binding: ActivityVideoPlayBinding
    private var player: SimpleExoPlayer? = null

    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L

    private fun initializePlayer() {
        player = SimpleExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                binding.videoPlayMain.player = exoPlayer

                val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp4))
                exoPlayer.setMediaItem(mediaItem)

                val secondMediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3));
                exoPlayer.addMediaItem(secondMediaItem);

                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.prepare()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_play)
    }

    override fun onStart() {
        super.onStart()
        
    }
    public override fun onResume() {
        super.onResume()
        if (player == null) {
            initializePlayer()
        }
    }

    public override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    public override fun onStop() {
        super.onStop()

    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        binding.videoPlayMain.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }


    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }
}