package com.octoprice.android.repository

import com.octoprice.android.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts(): List<Product>

    suspend fun getProduct(code: String): Product

    fun getProductFlow(code: String) : Flow<Product>
}