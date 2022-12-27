package com.learning.myudemy.presentation.video

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.databinding.DataBindingUtil
import com.learning.myudemy.R
import com.learning.myudemy.databinding.ActivityVideoPlayBinding
import com.learning.myudemy.presentation.base.LifecycleActivity

class VideoPlayActivity : LifecycleActivity() {
    lateinit var binding :ActivityVideoPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_play)

        val VIDEO_PATH = "android.resource://" + packageName + "/" + R.raw.vid_sample_sound

        var uri: Uri = Uri.parse(VIDEO_PATH)

        binding.videoPlayMain.setVideoURI(uri)
        binding.videoPlayMain.setMediaController(MediaController(this))     // 없으면 에러
        binding.videoPlayMain.requestFocus()    // 준비하는 과정을 미리함

        binding.btnStart.setOnClickListener{
            binding.videoPlayMain.start()
        }
        binding.btnEnd.setOnClickListener {
            binding.videoPlayMain.pause()
        }
    }
}