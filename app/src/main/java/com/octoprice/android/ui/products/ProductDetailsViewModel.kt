package com.octoprice.android.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octoprice.android.domain.model.Product
import com.octoprice.android.domain.usecase.GetProductUseCase
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val getProductUseCase: GetProductUseCase) : ViewModel() {
    private val _product: MutableLiveData<Product> = MutableLiveData()
    val product: LiveData<Product> = _product

    private val _loading : MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun loadProduct(product: Product) {
        _product.postValue(product)

        getAdditionalProductDataFromApi(product.code)
    }

    private fun getAdditionalProductDataFromApi(productCode: String) {
        viewModelScope.launch {
            _loading.value = true
            val product = getProductUseCase(productCode)
            _product.postValue(product)
            _loading.value = false
        }
    }
}