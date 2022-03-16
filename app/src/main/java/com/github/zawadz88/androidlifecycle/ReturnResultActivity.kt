package com.github.zawadz88.androidlifecycle

import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import kotlinx.android.synthetic.main.activity_return_result.*
import kotlinx.android.synthetic.main.activity_start_for_result.*
import timber.log.Timber

class ReturnResultActivity : BaseActivity(R.layout.activity_return_result) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        returnResult.setOnClickListener {
            setResult(789, Intent().putExtra("xxx", "yyy"))
            finish()
        }

        returnResultViaResultReceiver.setOnClickListener {
            val resultReceiver = intent.getParcelableExtra<ResultReceiver>("receiver")!!
            resultReceiver.send(999, Bundle().apply {
                putString("xxx", "zzz")
            })
            finish()
        }
    }

}


