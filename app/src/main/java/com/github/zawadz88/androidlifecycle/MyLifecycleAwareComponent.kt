package com.github.zawadz88.androidlifecycle

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import timber.log.Timber

class MyLifecycleAwareComponent: DefaultLifecycleObserver {

    override fun onResume(owner: LifecycleOwner) {
        Timber.d("Listening for location updates")
    }

    override fun onPause(owner: LifecycleOwner) {
        Timber.d("Stopped listening for location updates")
    }

}
