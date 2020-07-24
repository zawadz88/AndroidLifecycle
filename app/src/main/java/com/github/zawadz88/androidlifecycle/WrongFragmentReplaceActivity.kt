package com.github.zawadz88.androidlifecycle

import android.os.Bundle

class WrongFragmentReplaceActivity : BaseActivity(R.layout.activity_wrong_fragment_replace) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, NewFragment()).commit()
    }
}
