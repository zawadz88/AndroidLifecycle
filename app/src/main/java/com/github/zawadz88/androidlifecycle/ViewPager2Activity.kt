package com.github.zawadz88.androidlifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_view_pager2.viewPager

class ViewPager2Activity : BaseActivity(R.layout.activity_view_pager2) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 5

            override fun createFragment(position: Int): Fragment = newPageFragment(position)
        }
    }
}
