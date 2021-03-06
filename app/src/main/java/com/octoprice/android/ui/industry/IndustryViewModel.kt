package com.octoprice.android.ui.industry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IndustryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is industry Fragment"
    }
    val text: LiveData<String> = _text
}