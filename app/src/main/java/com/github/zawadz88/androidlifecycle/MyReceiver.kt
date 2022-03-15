package com.github.zawadz88.androidlifecycle

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import timber.log.Timber

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Timber.tag(this::class.java.name).d("onReceive: $intent")
    }
}
