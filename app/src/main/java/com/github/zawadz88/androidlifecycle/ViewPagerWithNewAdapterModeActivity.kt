package com.github.zawadz88.androidlifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_view_pager.viewPager

/**
 * @see androidx.fragment.app.FragmentTransaction.setMaxLifecycle
 */
class ViewPagerWithNewAdapterModeActivity : BaseActivity(R.layout.activity_view_pager) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            override fun getItem(position: Int): Fragment = newPageFragment(position)

            override fun getCount(): Int = 5
        }
    }
}
