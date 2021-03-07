package com.octoprice.android.domain.usecase

import com.octoprice.android.domain.model.Product
import com.octoprice.android.repository.ProductsRepository

class GetProductUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(code: String): Product {
        return productsRepository.getProduct(code)
    }
}
