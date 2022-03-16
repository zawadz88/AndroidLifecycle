package com.github.zawadz88.androidlifecycle

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

open class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    protected val tag: String
        get() = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag(tag).d("onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.tag(tag).d("onRestart")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(tag).d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(tag).d("onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // For more info when this gets called see: https://developer.android.com/reference/android/app/Activity#onSaveInstanceState(android.os.Bundle)
        Timber.tag(tag).d("onSaveInstanceState")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(tag).d("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(tag).d("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(tag).d("onDestroy")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.tag(tag).d("onActivityResult")
    }

    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        Timber.tag(tag).d("onTopResumedActivityChanged: $isTopResumedActivity")
    }
}
