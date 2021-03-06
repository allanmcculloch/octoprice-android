package com.octoprice.android.mappers

import com.octoprice.android.domain.model.Product
import com.octoprice.android.network.model.product.ProductResponse

class ProductMapper : DomainMapper<ProductResponse, Product> {
    override fun toDomain(model: ProductResponse): Product {
        return Product(
            availableFrom = model.available_from,
            availableTo = model.available_to,
            brand = model.brand,
            code = model.code,
            description = model.description,
            displayName = model.display_name,
            fullName = model.full_name,
            isBusiness = model.is_business,
            isGreen = model.is_green,
            isPrepay = model.is_prepay,
            isRestricted = model.is_restricted,
            isTracker = model.is_tracker,
            isVariable = model.is_variable,
            term = model.term
        )
    }
}