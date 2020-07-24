package com.github.zawadz88.androidlifecycle

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.defaultActivityButton
import kotlinx.android.synthetic.main.activity_main.dialogButton
import kotlinx.android.synthetic.main.activity_main.dialogFragmentButton
import kotlinx.android.synthetic.main.activity_main.replaceFragmentButton
import kotlinx.android.synthetic.main.activity_main.translucentActivityButton
import kotlinx.android.synthetic.main.activity_main.viewModelActivityButton
import kotlinx.android.synthetic.main.activity_main.viewPager2ActivityButton
import kotlinx.android.synthetic.main.activity_main.viewPagerInLegacyModeActivityButton
import kotlinx.android.synthetic.main.activity_main.viewPagerInNewModeActivityButton
import kotlinx.android.synthetic.main.activity_main.wrongFragmentReplaceActivityButton

class MainActivity : BaseActivity(R.layout.activity_main) {

    companion object {
        private const val REQUEST_CODE = 1234
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        defaultActivityButton.setOnClickListener {
            startActivityForResult(Intent(this, DefaultActivity::class.java), REQUEST_CODE)
        }
        translucentActivityButton.setOnClickListener {
            startActivityForResult(Intent(this, TranslucentActivity::class.java), REQUEST_CODE)
        }
        viewPagerInLegacyModeActivityButton.setOnClickListener {
            startActivity(Intent(this, ViewPagerWithLegacyAdapterModeActivity::class.java))
        }
        viewPagerInNewModeActivityButton.setOnClickListener {
            startActivity(Intent(this, ViewPagerWithNewAdapterModeActivity::class.java))
        }
        viewPager2ActivityButton.setOnClickListener {
            startActivity(Intent(this, ViewPager2Activity::class.java))
        }
        wrongFragmentReplaceActivityButton.setOnClickListener {
            startActivity(Intent(this, WrongFragmentReplaceActivity::class.java))
        }
        viewModelActivityButton.setOnClickListener {
            startActivity(Intent(this, ViewModelActivity::class.java))
        }
        dialogButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("I'm an AlertDialog")
                .setPositiveButton("OK") { _, _ -> }
                .show()
        }
        dialogFragmentButton.setOnClickListener {
            MyDialogFragment().show(supportFragmentManager, null)
        }
        replaceFragmentButton.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, NewFragment())
                .addToBackStack(null)
                .commit()
        }

        savedInstanceState ?: supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, MainFragment()).commit()
    }
}

class MyDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = AlertDialog.Builder(requireContext())
        .setMessage("I'm a DialogFragment")
        .setPositiveButton("OK") { _, _ -> }
        .create()
}


