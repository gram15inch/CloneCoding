package com.learning.myudemy.presentation.ui.bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.learning.myudemy.presentation.base.LifecycleFragment
import timber.log.Timber

open class ProxyLectureBottomSheetFragment:BottomSheetDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")

    }
    override fun onStart() {
        super.onStart()
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")

    }

    override fun onResume() {
        super.onResume()
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")

    }

    override fun onPause() {
        super.onPause()
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")

    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("lifecycle").d("${this.javaClass.simpleName} : ${object{}.javaClass.enclosingMethod?.name}")

    }
}