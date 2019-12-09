package com.example.counter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class CounterViewModel : ViewModel(){
    private val _counter = MutableLiveData<Int>()

    //var counter : Int = 0

    val counter : LiveData<Int>
        get() = _counter //getter

    init{
        Log.d("ViewModel", "ViewModel Initialised")
        _counter.value = 0
    }

    fun increment(){
        _counter.value = _counter.value?.plus(1)
    }

    fun decrement(){
        _counter.value = _counter.value?.minus(1)
    }

    override fun onCleared(){
        Log.d("ViewModel", "ViewModel Cleared")
        super.onCleared()
    }
}