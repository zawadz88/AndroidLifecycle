package com.github.zawadz88.androidlifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

open class BaseActivity : AppCompatActivity() {

    private val tag: String
        get() = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.tag(tag).d("onCreate")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(tag).d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(tag).d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(tag).d("onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.tag(tag).d("onRestart")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(tag).d("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(tag).d("onDestroy")
    }
}
