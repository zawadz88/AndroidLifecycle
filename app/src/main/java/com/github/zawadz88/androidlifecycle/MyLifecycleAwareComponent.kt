package com.github.zawadz88.androidlifecycle

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import timber.log.Timber

class MyLifecycleAwareComponent: DefaultLifecycleObserver {

    private val logtag: String
        get() = this::class.java.name

    override fun onResume(owner: LifecycleOwner) {
        Timber.tag(logtag).d("Listening for location updates")
    }

    override fun onPause(owner: LifecycleOwner) {
        Timber.tag(logtag).d("Stopped listening for location updates")
    }

}
