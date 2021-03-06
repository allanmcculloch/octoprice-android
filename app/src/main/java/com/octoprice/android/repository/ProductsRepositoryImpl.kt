package com.octoprice.android.repository

import com.octoprice.android.domain.model.Product
import com.octoprice.android.mappers.ProductMapper
import com.octoprice.android.network.OctopusApiService

class ProductsRepositoryImpl(
    private val octopusApiService: OctopusApiService,
    private val productMapper: ProductMapper
) : ProductsRepository {
    override suspend fun getProducts(): List<Product> {
        val productsResponse = octopusApiService.octopusClient.getProducts()

        val products = productsResponse.body()?.products.orEmpty()

        return products.map { productMapper.toDomain(it) }
    }

    override suspend fun getProduct(code: String): Product {
        val product = octopusApiService.octopusClient.getProduct(code).body()

        return productMapper.toDomain(product!!)
    }
}