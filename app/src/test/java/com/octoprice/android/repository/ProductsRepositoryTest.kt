package com.octoprice.android.repository

import com.octoprice.android.SampleData
import com.octoprice.android.mappers.ProductMapper
import com.octoprice.android.network.OctopusApiService
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class ProductsRepositoryTest {
    private lateinit var octopusApiServiceMock: OctopusApiService
    private lateinit var productMapperMock: ProductMapper

    private lateinit var productsRepository: ProductsRepository

    @Before
    fun setup() {
        octopusApiServiceMock = mockk(relaxed = true)
        productMapperMock = mockk(relaxed = true)

        coEvery { octopusApiServiceMock.octopusClient.getProducts() }.returns(
            Response.success(
                SampleData.productsResponse
            )
        )

        coEvery { octopusApiServiceMock.octopusClient.getProduct(SampleData.singleProductResponse.code) }.returns(
            Response.success(
                SampleData.singleProductResponse
            )
        )

        every { productMapperMock.toDomain(SampleData.productsResponse.products) }.returns(
            SampleData.products
        )
        every { productMapperMock.toDomain(SampleData.singleProductResponse) }.returns(SampleData.singleProduct)

        productsRepository = ProductsRepositoryImpl(octopusApiServiceMock, productMapperMock)
    }

    @Test
    fun `when calling getProducts returns domain products`() = runBlocking {
        val products = productsRepository.getProducts()

        assertEquals(SampleData.products, products)
    }

    @Test
    fun `when calling getProduct returns domain product`() = runBlocking {
        val product = productsRepository.getProduct(SampleData.singleProductResponse.code)

        assertEquals(SampleData.singleProduct, product)
    }
}