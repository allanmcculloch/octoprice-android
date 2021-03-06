package com.octoprice.android.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octoprice.android.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class ProductsViewModel(val getProductsUseCase: GetProductsUseCase) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is products Fragment"
    }
    val text: LiveData<String> = _text

    init {
        viewModelScope.launch {
            val products = getProductsUseCase.invoke()

            val names = StringBuilder()

            products.map { names.append(it.displayName) }

            _text.value = names.toString()
        }
    }
}