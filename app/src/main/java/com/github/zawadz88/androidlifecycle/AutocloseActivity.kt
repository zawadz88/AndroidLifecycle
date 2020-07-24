package com.github.zawadz88.androidlifecycle

import android.os.Bundle
import timber.log.Timber

class AutocloseActivity : BaseActivity(0) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("I don't want to live... Closing self")
        finish()
    }
}
