package com.octoprice.android

import com.octoprice.android.domain.model.Product
import com.octoprice.android.domain.model.SampleProductRates
import com.octoprice.android.network.model.gridsupplypoint.GridSupplyPointGroupId
import com.octoprice.android.network.model.gridsupplypoint.GridSupplyPointsResponse
import com.octoprice.android.network.model.product.*

object SampleData {
    val productsResponse = ProductsResponse(
        2, "", "", listOf(
            ProductResponse(
                available_from = "2021-02-16T00:00:00Z",
                available_to = null,
                brand = "AFFECT_ENERGY",
                code = "AFFECT-FIX-12M-21-02-16",
                description = "This tariff features 100% renewable electricity and fixes your unit rates and standing charge for 12 months. There are no exit fees, so if you change your mind, you're in control.",
                direction = "IMPORT",
                display_name = "Affect 12M Fixed",
                full_name = "Affect 12M Fixed February 2021 v1",
                is_business = false,
                is_green = true,
                is_prepay = false,
                is_restricted = true,
                is_tracker = false,
                is_variable = false,
                sample_consumption = null,
                tariffs_active_at = null,
                links = null,
                term = 12
            ),
            ProductResponse(
                available_from = "1900-01-01T00:00:00-00:01",
                available_to = "2199-12-31T00:00:00Z",
                brand = "COOP_ENERGY",
                code = "FEDQ0713-DD",
                description = "Fixed July 2013 - Big Switch Duo",
                direction = "IMPORT",
                display_name = "Fixed July 2013",
                full_name = "Fixed July 2013 - Big Switch Duo",
                is_business = false,
                is_green = false,
                is_prepay = false,
                is_restricted = false,
                is_tracker = false,
                is_variable = false,
                sample_consumption = null,
                tariffs_active_at = null,
                links = null,
                term = 99
            )
        )
    )

    val products = listOf(
        Product(
            availableFrom = "2021-02-16T00:00:00Z",
            availableTo = null,
            brand = "AFFECT_ENERGY",
            code = "AFFECT-FIX-12M-21-02-16",
            description = "This tariff features 100% renewable electricity and fixes your unit rates and standing charge for 12 months. There are no exit fees, so if you change your mind, you're in control.",
            displayName = "Affect 12M Fixed",
            fullName = "Affect 12M Fixed February 2021 v1",
            isBusiness = false,
            isGreen = true,
            isPrepay = false,
            isRestricted = true,
            isTracker = false,
            isVariable = false,
            term = 12
        ),
        Product(
            availableFrom = "1900-01-01T00:00:00-00:01",
            availableTo = "2199-12-31T00:00:00Z",
            brand = "COOP_ENERGY",
            code = "FEDQ0713-DD",
            description = "Fixed July 2013 - Big Switch Duo",
            displayName = "Fixed July 2013",
            fullName = "Fixed July 2013 - Big Switch Duo",
            isBusiness = false,
            isGreen = false,
            isPrepay = false,
            isRestricted = false,
            isTracker = false,
            isVariable = false,
            term = 99
        )
    )

    val singleProductResponse =
        ProductResponse(
            available_from = "2021-02-16T00:00:00Z",
            available_to = null,
            brand = "AFFECT_ENERGY",
            code = "AFFECT-FIX-12M-21-02-16",
            description = "This tariff features 100% renewable electricity and fixes your unit rates and standing charge for 12 months. There are no exit fees, so if you change your mind, you're in control.",
            direction = "IMPORT",
            display_name = "Affect 12M Fixed",
            full_name = "Affect 12M Fixed February 2021 v1",
            is_business = false,
            is_green = true,
            is_prepay = false,
            is_restricted = true,
            is_tracker = false,
            is_variable = false,
            sample_consumption = SampleConsumption(
                DualFuelDualRate(
                    electricity_day = 2436,
                    electricity_night = 1764,
                    gas_standard = 12000
                ),
                DualFuelSingleRate(electricity_standard = 2900, gas_standard = 12000),
                ElectricityDualRate(electricity_day = 2436, electricity_night = 1764),
                ElectricitySingleRate(electricity_standard = 2900)
            ),
            tariffs_active_at = null,
            links = null,
            term = 12,
            dual_register_electricity_tariffs = DualRegisterElectricityTariffs(
                ADualRegisterElectricity(
                    DirectDebitMonthlyDualRegisterElectricity(
                        day_unit_rate_inc_vat = 19.3515,
                        night_unit_rate_inc_vat = 10.563,
                        standing_charge_inc_vat = 24.486
                    )
                )
            ),
            single_register_electricity_tariffs = SingleRegisterElectricityTariffs(
                ASingleRegisterElectricity(
                    DirectDebitMonthlySingleRegisterElectricity(
                        standard_unit_rate_inc_vat = 17.136,
                        standing_charge_inc_vat = 24.486
                    )
                )
            )
        )

    val singleProduct = products.first()
    val updatedProduct =
        Product(
            availableFrom = "2021-02-16T00:00:00Z",
            availableTo = null,
            brand = "AFFECT_ENERGY",
            code = "AFFECT-FIX-12M-21-02-16",
            description = "This tariff features 100% renewable electricity and fixes your unit rates and standing charge for 12 months. There are no exit fees, so if you change your mind, you're in control.",
            displayName = "Affect 12M Fixed",
            fullName = "Affect 12M Fixed February 2021 v1",
            isBusiness = false,
            isGreen = true,
            isPrepay = false,
            isRestricted = true,
            isTracker = false,
            isVariable = false,
            term = 14,
            sampleProductRates = SampleProductRates(
                electricitySingleRate = 2900,
                electricityDualRateDay = 2436,
                electricityDualRateNight = 1764,
                dualFuelSingleRateElectricity = 2900,
                dualFuelSingleRateGas = 12000
            )
        )

    val gridSupplyPointsResponseSingle =
        GridSupplyPointsResponse(1, null, null, listOf(GridSupplyPointGroupId("_A")))

    val gridSupplyPointsResponseMultiple =
        GridSupplyPointsResponse(
            3,
            null,
            null,
            listOf(
                GridSupplyPointGroupId("_A"),
                GridSupplyPointGroupId("_C"),
                GridSupplyPointGroupId("_G")
            )
        )

    val gridSupplyPointsResponseNone =
        GridSupplyPointsResponse(0, null, null, listOf())
}