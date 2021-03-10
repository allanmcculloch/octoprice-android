package com.octoprice.android.repository

import com.octoprice.android.domain.model.Product
import com.octoprice.android.mappers.ProductMapper
import com.octoprice.android.network.OctopusApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.util.concurrent.ConcurrentHashMap

class ProductsRepositoryImpl(
    private val octopusApiService: OctopusApiService,
    private val productMapper: ProductMapper
) : ProductsRepository {
    private val cachedProducts = ConcurrentHashMap<String, Product>()  // TODO: Extract to in memory local repo

    override suspend fun getProducts(): List<Product> = withContext(Dispatchers.IO) {
        val productsResponse = octopusApiService.octopusClient.getProducts()

        val products = productsResponse.body()?.products.orEmpty()  // TODO: Handle success / error

        productMapper.toDomain(products)
    }

    override suspend fun getProduct(code: String): Product = withContext(Dispatchers.IO) {
        val product =
            octopusApiService.octopusClient.getProduct(code).body() // TODO: Handle success / error

        productMapper.toDomain(product!!)
    }

    override fun getProductFlow(code: String) = flow {
        if (cachedProducts.containsKey(code) && cachedProducts[code] != null)
            emit(cachedProducts[code]!!)

        val product = octopusApiService.octopusClient.getProduct(code).body()
        val productDomain = productMapper.toDomain(product!!)

        cachedProducts[code] = productDomain

        emit(productDomain)
    }
}