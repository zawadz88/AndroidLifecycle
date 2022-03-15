package com.github.zawadz88.androidlifecycle

import androidx.lifecycle.*
import timber.log.Timber

/**
 * @see https://proandroiddev.com/android-processlifecycleowner-by-example-2f965061b9da
 */
class ApplicationForegroundObserver : DefaultLifecycleObserver {

    private val logtag: String = this::class.java.name

    override fun onStart(owner: LifecycleOwner) {
        Timber.tag(logtag).d("I am in foreground!")
    }

    override fun onStop(owner: LifecycleOwner) {
        Timber.tag(logtag).d("I am in background :(")
    }
}

