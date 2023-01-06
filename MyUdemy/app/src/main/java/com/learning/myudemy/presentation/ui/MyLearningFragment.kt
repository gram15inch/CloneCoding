package com.learning.myudemy.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.learning.myudemy.R
import com.learning.myudemy.databinding.FragmentMyLearningBinding
import com.learning.myudemy.presentation.base.LifecycleFragment
import com.learning.myudemy.presentation.viewModel.MyLearningViewModel

class MyLearningFragment : LifecycleFragment() {

    private var _binding : FragmentMyLearningBinding? =null
    private val binding get() = _binding!!

    private val viewModel: MyLearningViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_learning, container, false)
        binding.myLearningList.lectureListContainer.setOnClickListener {
            val intent = Intent(context, VideoPlayActivity::class.java)
            intent.putExtra("videoUrl", R.string.media_url_mp4);
            startActivity(intent)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}