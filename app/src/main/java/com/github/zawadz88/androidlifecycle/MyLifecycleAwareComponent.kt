package com.github.zawadz88.androidlifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

class MyLifecycleAwareComponent: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun addLocationListener() {
        Timber.d("Listening for location updates")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun removeLocationListener() {
        Timber.d("Stopped listening for location updates")
    }
}
