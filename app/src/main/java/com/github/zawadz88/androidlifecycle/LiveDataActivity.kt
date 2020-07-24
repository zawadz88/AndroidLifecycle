package com.github.zawadz88.androidlifecycle

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.activity_livedata.goToNextActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LiveDataActivity : BaseActivity(R.layout.activity_livedata) {

    private val viewModel by viewModels<SampleViewModel>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // #1
        viewModel.state.observe(this, Observer {
            when (it) {
                SampleViewModel.ScreenState.Idle -> goToNextActivity.text = "Go to next Activity"
                SampleViewModel.ScreenState.Loading -> goToNextActivity.text = "Loading..."
                SampleViewModel.ScreenState.Loaded -> {
                    goToNextActivity.text = "Go to next Activity"
                    startActivity(Intent(this, DefaultActivity::class.java))
                }
            }.exhaustive
        })
        // #2
        // viewModel.state.observe(this, Observer {
        //     when (it) {
        //         SampleViewModel.ScreenState.Idle -> goToNextActivity.text = "Go to next Activity"
        //         SampleViewModel.ScreenState.Loading -> goToNextActivity.text = "Loading..."
        //     }.exhaustive
        // })
        // viewModel.action.observe(this, Observer {
        //     when (it) {
        //         SampleViewModel.ScreenAction.GoToNext -> {
        //             startActivity(Intent(this, DefaultActivity::class.java))
        //         }
        //     }
        // })
        goToNextActivity.setOnClickListener { viewModel.loadData() }
    }
}

// #1
class SampleViewModel : ViewModel() {

    private val _state = MutableLiveData<ScreenState>(ScreenState.Idle)

    val state: LiveData<ScreenState> = _state

    fun loadData() {
        if (state.value == ScreenState.Loading) return

        _state.value = ScreenState.Loading

        viewModelScope.launch {
            delay(3000L)
            _state.value = ScreenState.Loaded
        }
    }

    sealed class ScreenState {

        object Idle : ScreenState()

        object Loading : ScreenState()

        object Loaded : ScreenState()
    }
}

// #2
// class SampleViewModel : ViewModel() {
//
//     private val _state = MutableLiveData<ScreenState>(ScreenState.Idle)
//
//     val state: LiveData<ScreenState> = _state
//
//     val action: SingleLiveEvent<ScreenAction> = SingleLiveEvent()
//
//     fun loadData() {
//         if (state.value == ScreenState.Loading) return
//
//         _state.value = ScreenState.Loading
//
//         viewModelScope.launch {
//             delay(3000L)
//             _state.value = ScreenState.Idle
//             action.value = ScreenAction.GoToNext
//         }
//     }
//
//     sealed class ScreenState {
//
//         object Idle : ScreenState()
//
//         object Loading : ScreenState()
//     }
//
//     sealed class ScreenAction {
//
//         object GoToNext : ScreenAction()
//     }
// }
