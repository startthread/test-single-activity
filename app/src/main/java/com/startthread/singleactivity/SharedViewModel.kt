package com.startthread.singleactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val sharedData = MutableLiveData<Pair<String, Any>>()
}