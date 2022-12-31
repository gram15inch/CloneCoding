package com.learning.myudemy.presentation.video

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.learning.myudemy.R
import com.learning.myudemy.databinding.ActivityVideoPlayBinding
import com.learning.myudemy.presentation.base.LifecycleActivity

class VideoPlayActivity : LifecycleActivity() {
    lateinit var binding: ActivityVideoPlayBinding
    private val viewModel : VideoPlayActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.refreshVideoState()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_play)
    }

    override fun onRestart() {
        super.onRestart()
        if(viewModel.checkBackgroundPlay())
            backgroundVideo(false)
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }
    public override fun onResume() {
        super.onResume()
        binding.videoPlayMain.player?.play()
    }

    public override fun onPause() {
        super.onPause()
        playerStop()
    }

    public override fun onStop() {
        super.onStop()
        if(viewModel.checkBackgroundPlay())
            backgroundVideo(true)
        viewModel.storeVideoState()
    }

    public override fun onDestroy() {
        super.onDestroy()
        releasePlayer()
    }

    private fun initializePlayer() {
        if(viewModel.player != null)
            releasePlayer()
        viewModel.player = SimpleExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                binding.videoPlayMain.player = exoPlayer

                val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp4))
                exoPlayer.setMediaItem(mediaItem)

                val secondMediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3));
                exoPlayer.addMediaItem(secondMediaItem);

                exoPlayer.playWhenReady = viewModel.playWhenReady
                exoPlayer.seekTo(viewModel.currentWindow, viewModel.playbackPosition)
                exoPlayer.prepare()
            }
    }

    private fun playerStop() {
        binding.videoPlayMain.player?.stop()
        viewModel.player?.run {
            viewModel.playbackPosition = this.currentPosition
            viewModel.currentWindow = this.currentWindowIndex
            viewModel.playWhenReady = this.playWhenReady
        }
    }

    private fun releasePlayer() {
        viewModel.player?.release()
        viewModel.player = null
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


    private fun backgroundVideo(bool: Boolean){
        val text = if(bool) "start" else "stop"
        Toast.makeText(this,"background $text!!",Toast.LENGTH_SHORT).show()
    }
}