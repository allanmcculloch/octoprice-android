package com.octoprice.android.network.model.product

import com.squareup.moshi.Json

data class ProductsResponse(
    val count: Int?,
    val next: String?,
    val previous: String?,
    @field:Json(name = "results") val products: List<ProductResponse>
)

