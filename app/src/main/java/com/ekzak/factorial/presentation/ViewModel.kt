package com.ekzak.factorial.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val progress = MutableLiveData<Boolean>()
    private val result = MutableLiveData<String>()
    private val error = MutableLiveData<Boolean>()

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Boolean>) {
        progress.observe(owner, observer)
    }

    fun observeResult(owner: LifecycleOwner, observer: Observer<String>) {
        result.observe(owner, observer)
    }

    fun observeError(owner: LifecycleOwner, observer: Observer<Boolean>) {
        error.observe(owner, observer)
    }

    fun calculate(number: String?) {
        progress.value = true
        if (number.isNullOrBlank()) {
            error.value = true
            progress.value = false
            return
        }
        viewModelScope.launch {
            val num = number.toInt()
            delay(1000)
            // todo make calculation
            progress.value = false
        }
    }
}
