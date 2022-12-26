package com.learning.myudemy.presentation.mylearning

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.learning.myudemy.R
import com.learning.myudemy.databinding.FragmentMyLearningBinding
import com.learning.myudemy.presentation.base.LifecycleFragment

class MyLearningFragment : LifecycleFragment() {

    lateinit var binding : FragmentMyLearningBinding
    private val viewModel: MyLearningViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_learning, container, false)
        return binding.root
    }


}