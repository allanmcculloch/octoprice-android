package com.octoprice.android.domain.usecase

import com.octoprice.android.domain.model.Product
import com.octoprice.android.repository.ProductsRepository

class GetProductsUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(): List<Product> =
        productsRepository.getProducts()

}