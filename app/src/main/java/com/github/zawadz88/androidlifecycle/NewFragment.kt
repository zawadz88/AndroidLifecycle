package com.github.zawadz88.androidlifecycle

class NewFragment : BaseFragment(R.layout.fragment_new) {

    override val logtag: String
        get() = this::class.java.name + this.hashCode()
}
