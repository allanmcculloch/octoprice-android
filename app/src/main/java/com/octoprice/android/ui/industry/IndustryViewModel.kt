package com.octoprice.android.ui.industry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IndustryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "To show industry grid supply points"
    }
    val text: LiveData<String> = _text
}