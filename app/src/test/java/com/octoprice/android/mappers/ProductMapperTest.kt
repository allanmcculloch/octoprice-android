package com.octoprice.android.mappers

import com.octoprice.android.SampleData
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.Before

class ProductMapperTest {
    lateinit var productMapper: ProductMapper

    @Before
    fun setup() {
        productMapper = ProductMapper()
    }

    @Test
    fun `toDomain() maps product correctly`() {
        val sampleProductResponse = SampleData.singleProductResponse

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

    @Test
    fun `toDomain() maps sample product rates correctly`() {
        val sampleProductResponse = SampleData.singleProductResponse
        val product = productMapper.toDomain(sampleProductResponse)

        assertEquals(sampleProductResponse.sample_consumption?.electricity_single_rate?.electricity_standard, product.sampleProductRates?.electricitySingleRate)

        assertEquals(sampleProductResponse.sample_consumption?.electricity_dual_rate?.electricity_day, product.sampleProductRates?.electricityDualRateDay)
        assertEquals(sampleProductResponse.sample_consumption?.electricity_dual_rate?.electricity_night, product.sampleProductRates?.electricityDualRateNight)

        assertEquals(sampleProductResponse.sample_consumption?.dual_fuel_single_rate?.electricity_standard, product.sampleProductRates?.dualFuelSingleRateElectricity)
        assertEquals(sampleProductResponse.sample_consumption?.dual_fuel_single_rate?.gas_standard, product.sampleProductRates?.dualFuelSingleRateGas)
    }

    @Test
    fun `toDomain() maps tariffs correctly`() {
        val sampleProductResponse = SampleData.singleProductResponse
        val product = productMapper.toDomain(sampleProductResponse)

        assertEquals(sampleProductResponse.single_register_electricity_tariffs?._A?.direct_debit_monthly?.standard_unit_rate_inc_vat, product.singleRegisterElectricity?.standardUnitRate)
        assertEquals(sampleProductResponse.single_register_electricity_tariffs?._A?.direct_debit_monthly?.standing_charge_inc_vat, product.singleRegisterElectricity?.standingCharge)

        assertEquals(sampleProductResponse.dual_register_electricity_tariffs?._A?.direct_debit_monthly?.day_unit_rate_inc_vat, product.dualRegisterElectricity?.dayUnitRate)
        assertEquals(sampleProductResponse.dual_register_electricity_tariffs?._A?.direct_debit_monthly?.night_unit_rate_inc_vat, product.dualRegisterElectricity?.nightUnitRate)
        assertEquals(sampleProductResponse.dual_register_electricity_tariffs?._A?.direct_debit_monthly?.standing_charge_inc_vat, product.dualRegisterElectricity?.standingCharge)
    }

    @Test
    fun `toDomain() maps products list correctly`() {
        val sampleProductsResponse = SampleData.productsResponse
        val products = productMapper.toDomain(sampleProductsResponse.products)

        assertEquals(SampleData.products, products)
    }
}