package com.learning.myudemy.ui.recommendation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learning.myudemy.R

class RecommendationFragment : Fragment() {

    companion object {
        fun newInstance() = RecommendationFragment()
    }

    private lateinit var viewModel: RecommendationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recommendation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecommendationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}