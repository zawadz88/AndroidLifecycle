package com.github.zawadz88.androidlifecycle

import android.os.Bundle

class LifecycleOwnerActivity : BaseActivity(R.layout.activity_lifecycle_owner) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyLifecycleAwareComponent())
    }
}
