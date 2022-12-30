package com.learning.myudemy.presentation.mylearning

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
import com.learning.myudemy.presentation.video.VideoPlayActivity

class MyLearningFragment : LifecycleFragment() {

    private var _binding : FragmentMyLearningBinding? =null
    private val binding get() = _binding!!

    private val viewModel: MyLearningViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_learning, container, false)
        binding.testlayout1.lectureListContainer.setOnClickListener {
            val intent = Intent(context,VideoPlayActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}