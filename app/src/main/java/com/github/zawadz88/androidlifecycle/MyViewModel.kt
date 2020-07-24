package com.github.zawadz88.androidlifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.Arrays
import kotlin.random.Random

class MyViewModel(
    // #4, #5
    // private val state: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val DATA_KEY = "data"
    }

    private val repository: MyRepository = MyRepository()

    // #1, #2, #3
    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    // #4
    // val liveData: LiveData<String> = state.getLiveData(DATA_KEY)

    // #3, #4, #5
    init {
        // loadData()
    }

    fun loadData() {
        // #1, #2, #3
        viewModelScope.launch {
            _liveData.postValue(repository.loadData())
        }

        // #4, #5
        // state.get<String>(DATA_KEY) ?: viewModelScope.launch {
        //     val loadedData = repository.loadData()
        //     withContext(Dispatchers.Main) {
        //         state.set(DATA_KEY, loadedData)
        //     }
        // }
    }
}

class MyRepository {

    suspend fun loadData(): String {
        Timber.d("Loading data...")
        delay(2000L)
        Timber.d("Data loaded successfully")
        // #1, #2, #3, #4
        return "The data I was waiting for: ${Random.nextInt()}"
        // #5
        // return "${Random.nextInt()} ${createBigDataString()}"
    }

    private fun createBigDataString(): String {
        val chars = CharArray(1024 * 1024)
        Arrays.fill(chars, 'f')
        return String(chars)
    }
}
