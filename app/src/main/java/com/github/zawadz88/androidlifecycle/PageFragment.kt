package com.github.zawadz88.androidlifecycle

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.fragment_page.textView
import timber.log.Timber

private const val PAGE = "pagePosition"

class PageFragment : BaseFragment(R.layout.fragment_page) {

    override val logtag: String
        get() = "${super.logtag} #${arguments?.getInt(PAGE) ?: "???"}"

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView.text = "Page fragment #${requireArguments().getInt(PAGE)}"
    }

    @Suppress("DEPRECATION")
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Timber.tag(logtag).d("setUserVisibleHint: $isVisibleToUser")
    }
}

fun newPageFragment(pagePosition: Int): PageFragment = PageFragment().apply {
    arguments = bundleOf(PAGE to pagePosition)
}
