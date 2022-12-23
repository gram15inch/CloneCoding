package com.learning.myudemy.ui.mylearning

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learning.myudemy.R

class MyLearningFragment : Fragment() {

    companion object {
        fun newInstance() = MyLearningFragment()
    }

    private lateinit var viewModel: MyLearningViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_learning, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyLearningViewModel::class.java)
        // TODO: Use the ViewModel
    }

}