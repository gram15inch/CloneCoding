package com.learning.myudemy.presentation.recommendation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.learning.myudemy.R
import com.learning.myudemy.databinding.FragmentRecommendationBinding


class RecommendationFragment : Fragment() {

    lateinit var binding : FragmentRecommendationBinding
    private val viewModel: RecommendationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_recommendation, container, false)
        binding.testName1 ="${viewModel.str}"
        binding.testName2 ="안안녕안녕"
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.imgTest
    }

}