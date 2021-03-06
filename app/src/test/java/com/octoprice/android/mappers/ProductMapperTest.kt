package com.octoprice.android.mappers

import com.octoprice.android.network.model.product.ProductResponse
import junit.framework.Assert.assertEquals
import org.junit.Test

import org.junit.Before

class ProductMapperTest {

    lateinit var productMapper : ProductMapper
    @Before
    fun setup() {
        productMapper = ProductMapper()
    }

    @Test
    fun mapsCorrectly() {
        val product = productMapper.toDomain(sampleProductResponse)

        assertEquals(sampleProductResponse.available_from, product.availableFrom)
        assertEquals(sampleProductResponse.available_to, product.availableTo)
        assertEquals(sampleProductResponse.brand, product.brand)
        assertEquals(sampleProductResponse.code, product.code)
        assertEquals(sampleProductResponse.description, product.description)
        assertEquals(sampleProductResponse.display_name, product.displayName)
        assertEquals(sampleProductResponse.full_name, product.fullName)
        assertEquals(sampleProductResponse.is_business, product.isBusiness)
        assertEquals(sampleProductResponse.is_green, product.isGreen)
        assertEquals(sampleProductResponse.is_prepay, product.isPrepay)
        assertEquals(sampleProductResponse.is_restricted, product.isRestricted)
        assertEquals(sampleProductResponse.is_tracker, product.isTracker)
        assertEquals(sampleProductResponse.is_variable, product.isVariable)
        assertEquals(sampleProductResponse.term, product.term)
    }

    val sampleProductResponse = ProductResponse(
        "2021-02-16T00:00:00Z",
        null,
        "AFFECT_ENERGY",
        "AFFECT-FIX-12M-21-02-16",
        "This tariff features 100% renewable electricity and fixes your unit rates and standing charge for 12 months. There are no exit fees, so if you change your mind, you're in control.",
        null,
        "Affect 12M Fixed",
        "Affect 12M Fixed February 2021 v1",
        false,
        true,
        false,
        true,
        false,
        false,
        null,
        null,
        null,
        12
    )
}