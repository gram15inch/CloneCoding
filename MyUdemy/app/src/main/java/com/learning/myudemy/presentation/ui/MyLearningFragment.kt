package com.learning.myudemy.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.learning.myudemy.R
import com.learning.myudemy.databinding.FragmentMyLearningBinding
import com.learning.myudemy.presentation.adapter.MyLearningAdapter
import com.learning.myudemy.presentation.model.UiMyLeaningLecture
import com.learning.myudemy.presentation.viewModel.MyLearningViewModel
import dagger.hilt.android.AndroidEntryPoint

@BindingAdapter("myLeaningList")
fun bindMyLeaningList(view: RecyclerView, list: List<UiMyLeaningLecture>?) {
    val adapter = (view.adapter as MyLearningAdapter)
    val listNotNull = list ?: emptyList()
    if (listNotNull != adapter.currentList)
        adapter.submitList(list)
}

@AndroidEntryPoint
class MyLearningFragment : Fragment() {

    private var _binding: FragmentMyLearningBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyLearningViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_learning, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.myLearningListRyc.adapter = MyLearningAdapter(itemClickListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   private val itemClickListener: (UiMyLeaningLecture) -> Unit = {
       val intent = Intent(context, VideoPlayActivity::class.java)
       intent.putExtra("classfyCode",it.classfyCode)
       startActivity(intent)
    }

    private fun startVideoActivity() {
        val intent = Intent(context, VideoPlayActivity::class.java)
        intent.putExtra("videoUrl", R.string.media_url_mp4)
        startActivity(intent)
    }
}