package com.octoprice.android.repository

import com.octoprice.android.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts() : List<Product>

    suspend fun getProduct(code: String): Product
}