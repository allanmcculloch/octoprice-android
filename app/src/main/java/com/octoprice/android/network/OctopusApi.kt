package com.octoprice.android.network

import com.octoprice.android.network.model.gridsupplypoint.GridSupplyPointsResponse
import com.octoprice.android.network.model.product.ProductResponse
import com.octoprice.android.network.model.product.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface OctopusApi {
    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>

    @GET("products/{code}")
    suspend fun getProduct(code: String): Response<ProductResponse>

    @GET("industry/grid-supply-points")
    suspend fun getIndustryGridSupplyPoints() : Response<GridSupplyPointsResponse>
}