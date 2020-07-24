package com.github.zawadz88.androidlifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

/**
 * @see https://proandroiddev.com/android-processlifecycleowner-by-example-2f965061b9da
 */
class ApplicationForegroundObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        Timber.d("I am in foreground!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        Timber.d("I am in background :(")
    }
}
