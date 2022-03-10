package com.github.zawadz88.androidlifecycle

import androidx.lifecycle.*
import timber.log.Timber

/**
 * @see https://proandroiddev.com/android-processlifecycleowner-by-example-2f965061b9da
 */
class ApplicationForegroundObserver : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        Timber.d("I am in foreground!")
    }

    override fun onStop(owner: LifecycleOwner) {
        Timber.d("I am in background :(")
    }
}
