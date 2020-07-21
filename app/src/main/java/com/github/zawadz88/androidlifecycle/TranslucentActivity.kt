package com.github.zawadz88.androidlifecycle

import android.os.Bundle

class TranslucentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translucent)
    }
}
