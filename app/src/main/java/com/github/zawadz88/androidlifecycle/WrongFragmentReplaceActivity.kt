package com.github.zawadz88.androidlifecycle

import android.os.Bundle

class WrongFragmentReplaceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wrong_fragment_replace)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, NewFragment()).commit()
    }
}
