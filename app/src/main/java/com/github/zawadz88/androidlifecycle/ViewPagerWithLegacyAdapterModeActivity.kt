package com.github.zawadz88.androidlifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_view_pager.viewPager

class ViewPagerWithLegacyAdapterModeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        @Suppress("DEPRECATION")
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_SET_USER_VISIBLE_HINT) {

            override fun getItem(position: Int): Fragment = newPageFragment(position)

            override fun getCount(): Int = 5
        }
    }
}
