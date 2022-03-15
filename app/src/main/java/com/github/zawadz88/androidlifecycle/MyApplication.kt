package com.github.zawadz88.androidlifecycle

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
        Timber.tag(this::class.java.name).d("onCreate")
        ProcessLifecycleOwner
            .get()
            .lifecycle
            .addObserver(ApplicationForegroundObserver())
    }
}
