package com.learning.myudemy.ui.recommendation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.AppBarConfiguration
import com.learning.myudemy.MainActivity
import com.learning.myudemy.R
import com.learning.myudemy.databinding.FragmentRecommendationBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RecommendationFragment : Fragment() {

    lateinit var binding : FragmentRecommendationBinding
    companion object {
        fun newInstance() = RecommendationFragment()
    }

    private lateinit var viewModel: RecommendationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_recommendation, container, false)
        binding.testName =" test name"
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecommendationViewModel::class.java)

    }

}