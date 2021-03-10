package com.octoprice.android.domain.usecase

import com.octoprice.android.domain.model.Product
import com.octoprice.android.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(code: String): Flow<Product> =
        productsRepository.getProductFlow(code)
}
