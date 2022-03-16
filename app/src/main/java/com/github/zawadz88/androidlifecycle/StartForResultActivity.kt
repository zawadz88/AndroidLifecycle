package com.github.zawadz88.androidlifecycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import androidx.activity.result.contract.ActivityResultContract
import kotlinx.android.synthetic.main.activity_start_for_result.*
import timber.log.Timber

class StartForResultActivity : BaseActivity(R.layout.activity_start_for_result) {

    companion object {
        private const val REQUEST_CODE = 1234
    }

    private val resultReceiver by lazy {
        object : ResultReceiver(root.handler) {

            override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                Timber.tag(tag)
                    .d("onReceiveResult -> resultCode: $resultCode, resultReceiver: $this, , activity: ${this@StartForResultActivity}")
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        legacy.setOnClickListener {
            startActivityForResult(Intent(this, ReturnResultActivity::class.java), REQUEST_CODE)
        }
        legacyWithReceiver.setOnClickListener {
            Timber.tag(tag).d("Starting with result receiver: $resultReceiver, activity: $this")
            startActivityForResult(
                Intent(this, ReturnResultActivity::class.java)
                    .putExtra("receiver", resultReceiver),
                REQUEST_CODE
            )
        }
        val startForResult = registerForActivityResult(GetDataContract()) { result: String ->
            Timber.tag(tag)
                .d("ActivityResult callback -> result: $result, activity: $this")
        }
        androidxActivityResult.setOnClickListener {
            Timber.tag(tag).d("Starting with result callback, activity: $this")
            startForResult.launch(null)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.tag(tag)
            .d("onActivityResult -> requestCode: $requestCode, resultCode: $resultCode, activity: $this")
    }

    class GetDataContract : ActivityResultContract<Unit?, String>() {
        override fun createIntent(context: Context, input: Unit?) =
            Intent(context, ReturnResultActivity::class.java)

        override fun parseResult(resultCode: Int, intent: Intent?): String =
            "Result code: $resultCode"
    }

}


