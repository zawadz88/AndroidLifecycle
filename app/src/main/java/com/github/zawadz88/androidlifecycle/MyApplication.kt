package com.github.zawadz88.androidlifecycle

import android.app.Application
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
        Timber.d( "onCreate")
    }
}
