package com.learning.myudemy.ui.recommendation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.ui.AppBarConfiguration
import com.learning.myudemy.MainActivity
import com.learning.myudemy.R
import com.learning.myudemy.databinding.FragmentRecommendationBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject



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