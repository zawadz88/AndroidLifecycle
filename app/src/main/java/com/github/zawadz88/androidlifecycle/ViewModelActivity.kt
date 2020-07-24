package com.github.zawadz88.androidlifecycle

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_viewmodel.textView

class ViewModelActivity : BaseActivity(R.layout.activity_viewmodel) {

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
         * On Android P+ emulator simulate process death by:
         * adb shell ps -A |grep androidlifecycle
         * Press Home button
         * adb shell am kill com.github.zawadz88.androidlifecycle
         * Open the app from Recent Apps
         *
         * Source: https://codelabs.developers.google.com/codelabs/android-lifecycles/#6
         */
        // #1
        viewModel.loadData()
        // #2
        // savedInstanceState ?: viewModel.loadData()
        // #3
        // load in constructor
        // #4
        // same as #3 but with SavedInstance https://developer.android.com/topic/libraries/architecture/viewmodel-savedstate
        // Also see: https://developer.android.com/topic/libraries/architecture/saving-states
        // and https://medium.com/@sandeeptengale/problem-solved-1-transactiontoolargeexception-in-nougat-18da99805e63
        /*
         Do not use store onSavedInstanceState() to store large amounts of data, such as bitmaps, nor complex data structures that require lengthy serialization or deserialization.
         Instead, store only primitive types and simple, small objects such as String.
         As such, use onSaveInstanceState() to store a minimal amount of data necessary, such as an ID, to re-create the data necessary to restore the UI back to its previous state
          should the other persistence mechanisms fail. Most apps should implement onSaveInstanceState() to handle system-initiated process death.
         */
        //#5
        // see what happens with a large data saved in the bundle
        /*
        java.lang.RuntimeException: android.os.TransactionTooLargeException: data parcel size 2099084 bytes
            at android.app.servertransaction.PendingTransactionActions$StopInfo.run(PendingTransactionActions.java:160)
            at android.os.Handler.handleCallback(Handler.java:873)
            at android.os.Handler.dispatchMessage(Handler.java:99)
            at android.os.Looper.loop(Looper.java:193)
            at android.app.ActivityThread.main(ActivityThread.java:6669)
            at java.lang.reflect.Method.invoke(Native Method)
            at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493)
            at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:858)
        Caused by: android.os.TransactionTooLargeException: data parcel size 2099084 bytes
         */

        viewModel.liveData.observe(this, Observer { data ->
            textView.text = data
        })
    }
}
