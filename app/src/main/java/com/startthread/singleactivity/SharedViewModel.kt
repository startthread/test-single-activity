package com.startthread.singleactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.startthread.singleactivity.infra.SingleLiveEvent

class SharedViewModel : ViewModel() {
    val sharedData: MutableLiveData<Pair<String, Any>> = SingleLiveEvent()
}
