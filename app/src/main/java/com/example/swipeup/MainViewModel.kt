package com.example.swipeup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _isLoading = MutableStateFlow(value = false)
    val isLoading = _isLoading.asStateFlow()
    init {
        loadStuff()
    }
    fun loadStuff(){
        viewModelScope.launch { _isLoading.value=true
        delay(4500)
            _isLoading.value=false
        }
    }
}