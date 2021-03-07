package com.octoprice.android.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octoprice.android.R
import com.octoprice.android.adapter.RecyclerViewItem
import com.octoprice.android.domain.model.Product
import com.octoprice.android.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.launch
import com.octoprice.android.BR
import com.octoprice.android.util.SingleLiveEvent

class ProductsViewModel(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {
    private val _products = MutableLiveData<List<RecyclerViewItem>>()
    val products: LiveData<List<RecyclerViewItem>> = _products
    val navigateToProductDetail: SingleLiveEvent<Product> = SingleLiveEvent()

    fun loadProducts() {
        viewModelScope.launch {
            val products = getProductsUseCase()
            _products.value = products.map { it.toRecyclerItem(this@ProductsViewModel) }
        }
    }

    fun onProductClick(product: Product) {
        navigateToProductDetail.postValue(product)
    }

    private fun Product.toRecyclerItem(viewModel: ProductsViewModel) =
        RecyclerViewItem(
            dataItem = this,
            variableId = BR.product,
            layoutId = R.layout.item_product,
            viewModel = viewModel
        )
}

