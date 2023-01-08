package com.learning.myudemy.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.myudemy.R
import com.learning.myudemy.databinding.FragmentRecommendationBinding
import com.learning.myudemy.presentation.adapter.LectureAdapter
import com.learning.myudemy.presentation.adapter.RecommendAdapter
import com.learning.myudemy.presentation.base.LifecycleFragment
import com.learning.myudemy.presentation.model.UiLecture
import com.learning.myudemy.presentation.model.UiRecommend
import com.learning.myudemy.presentation.viewModel.RecommendationViewModel
import dagger.hilt.android.AndroidEntryPoint

@BindingAdapter("lectureList")
fun bindLectureList(view: RecyclerView,list:List<UiLecture>?){
    val adapter = LectureAdapter(){}
    adapter.submitList(list?: emptyList())
    view.adapter = adapter
    view.layoutManager = LinearLayoutManager(view.rootView.context,LinearLayoutManager.HORIZONTAL,false)
}
@BindingAdapter("recommendList")
fun bindRmdList(view: RecyclerView,list:List<UiRecommend>?){
    (view.adapter as RecommendAdapter).submitList(list?: emptyList())
}

@AndroidEntryPoint
class RecommendationFragment : LifecycleFragment() {

    var _binding : FragmentRecommendationBinding? =null
    private val binding get() = _binding!!
    private val viewModel: RecommendationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recommendation, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recommendListRyc.adapter = RecommendAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}