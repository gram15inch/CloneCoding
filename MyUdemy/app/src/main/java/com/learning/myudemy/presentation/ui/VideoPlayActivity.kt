package com.learning.myudemy.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.learning.myudemy.R
import com.learning.myudemy.databinding.ActivityVideoPlayBinding
import com.learning.myudemy.domain.converter.DomainConverter.id
import com.learning.myudemy.presentation.adapter.VideoPlayAdapter
import com.learning.myudemy.presentation.base.LifecycleActivity
import com.learning.myudemy.presentation.model.UiLecture
import com.learning.myudemy.presentation.model.UiMyLeaningLecture
import com.learning.myudemy.presentation.viewModel.VideoPlayViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

@BindingAdapter("videoList")
fun bindVideoList(view: RecyclerView, list:List<UiLecture>?){
    if(list!= null)
        Timber.tag("intent").d("${list}")
    (view.adapter as VideoPlayAdapter).submitList(list?: emptyList())
}
@AndroidEntryPoint
class VideoPlayActivity : LifecycleActivity() {
    lateinit var binding: ActivityVideoPlayBinding
    private val viewModel : VideoPlayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.getStringExtra("classfyCode").apply {
            Timber.tag("classCode").d("code: $this")
            viewModel.refreshUiMyLeaningLecture(toId(this?:""))
        }

        viewModel.refreshVideoState()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_play)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.videoLectureListRyc.adapter = VideoPlayAdapter(itemClickListener)
    }

    private val itemClickListener: (UiLecture) -> Unit = {
        viewModel.refreshVideoState()
    }

    private fun toId(code:String):Int{
        return when(code){
            "ACRC01"->{1}
            "ACRC02"->{2}
            "AIIA01"->{3}
            else->1
        }
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
        //binding.videoPlayMain.player?.play() //todo 다시 재생
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

                val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp4)) //todo 받아온 값으로 교체
                exoPlayer.setMediaItem(mediaItem)

                val secondMediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3))
                exoPlayer.addMediaItem(secondMediaItem)

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
        //Toast.makeText(this,"background $text!!",Toast.LENGTH_SHORT).show()
    }
}