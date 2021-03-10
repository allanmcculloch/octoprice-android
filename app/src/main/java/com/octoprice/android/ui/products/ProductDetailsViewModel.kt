package com.octoprice.android.ui.products

import androidx.lifecycle.*
import com.octoprice.android.domain.model.Product
import com.octoprice.android.domain.usecase.GetProductUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val getProductUseCase: GetProductUseCase) : ViewModel() {
    private val _product: MutableLiveData<Product> = MutableLiveData()
    val product: LiveData<Product> = _product

    private val _loading : MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun loadProduct(product: Product) {
        _product.value = product
        getAdditionalProductDataFromApi(product.code)
    }

    private fun getAdditionalProductDataFromApi(productCode: String) {
        viewModelScope.launch {
            _loading.value = true
            getProductUseCase(productCode).collect {
               _product.value = it
            }

            _loading.value = false
        }
    }
}