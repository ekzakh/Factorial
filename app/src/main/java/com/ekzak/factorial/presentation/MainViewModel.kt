package com.ekzak.factorial.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val state = MutableLiveData<State>()

    fun observeState(owner: LifecycleOwner, observer: Observer<State>) {
        state.observe(owner, observer)
    }

    fun calculate(number: String?) {
        state.value = State(isInProgress = true)
        if (number.isNullOrBlank()) {
            state.value = State(isError = true)
            return
        }
        viewModelScope.launch {
            val num = number.toInt()
            delay(1000)
            // todo make calculation
            state.value = State(factorial = "todo")
        }
    }
}
