package com.octoprice.android.mappers

import com.octoprice.android.domain.model.Product
import com.octoprice.android.network.model.product.ProductResponse

class ProductMapper : DomainMapper<ProductResponse, Product> {
    override fun toDomain(productResponse: ProductResponse): Product =
        Product(
            availableFrom = productResponse.available_from,
            availableTo = productResponse.available_to,
            brand = productResponse.brand,
            code = productResponse.code,
            description = productResponse.description,
            displayName = productResponse.display_name,
            fullName = productResponse.full_name,
            isBusiness = productResponse.is_business,
            isGreen = productResponse.is_green,
            isPrepay = productResponse.is_prepay,
            isRestricted = productResponse.is_restricted,
            isTracker = productResponse.is_tracker,
            isVariable = productResponse.is_variable,
            term = productResponse.term
        )

    fun toDomain(productsResponse: List<ProductResponse>): List<Product> =
        productsResponse.map { toDomain(it) }
}