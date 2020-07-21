package com.github.zawadz88.androidlifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import timber.log.Timber

open class BaseFragment(@LayoutRes layoutResId: Int): Fragment(layoutResId) {

    protected open val logtag: String
        get() = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag(logtag).d("onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.tag(logtag).d("onActivityCreated")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        Timber.tag(logtag).d("onCreateView")
        return view
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(logtag).d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(logtag).d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(logtag).d("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(logtag).d("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag(logtag).d("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(logtag).d("onDestroy")
    }

}
