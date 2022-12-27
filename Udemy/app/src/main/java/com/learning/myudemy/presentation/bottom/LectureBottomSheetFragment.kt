package com.learning.myudemy.presentation.bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learning.myudemy.R

class LectureBottomSheetFragment: ProxyLectureBottomSheetFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lecture_bottom_sheet, container, false)
    }
}