package com.octoprice.android.mappers

import com.octoprice.android.domain.model.Product
import com.octoprice.android.domain.model.SampleProductRates
import com.octoprice.android.domain.model.TariffsDualRegisterElectricity
import com.octoprice.android.domain.model.TariffsSingleRegisterElectricity
import com.octoprice.android.network.model.product.DualRegisterElectricityTariffs
import com.octoprice.android.network.model.product.ProductResponse
import com.octoprice.android.network.model.product.SampleConsumption
import com.octoprice.android.network.model.product.SingleRegisterElectricityTariffs

class ProductMapper : DomainMapper<ProductResponse, Product> {
    override fun toDomain(model: ProductResponse): Product =
        Product(
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
            term = model.term,
            sampleProductRates = mapSampleRates(model.sample_consumption),
            dualRegisterElectricity = mapDualRegisterElectricity(model.dual_register_electricity_tariffs),
            singleRegisterElectricity = mapSingleRegisterElectricity(model.single_register_electricity_tariffs)
        )

    fun toDomain(productsResponse: List<ProductResponse>): List<Product> =
        productsResponse.map { toDomain(it) }

    private fun mapSampleRates(sampleConsumption: SampleConsumption?): SampleProductRates? =
        sampleConsumption?.let {
            SampleProductRates(
                electricitySingleRate = it.electricity_single_rate?.electricity_standard,
                electricityDualRateDay = it.electricity_dual_rate?.electricity_day,
                electricityDualRateNight = it.electricity_dual_rate?.electricity_night,
                dualFuelSingleRateElectricity = it.dual_fuel_single_rate?.electricity_standard,
                dualFuelSingleRateGas = it.dual_fuel_single_rate?.gas_standard
            )
        }

    private fun mapDualRegisterElectricity(dualRegisterElectricityTariffs: DualRegisterElectricityTariffs?): TariffsDualRegisterElectricity? =
        dualRegisterElectricityTariffs?.let {
            TariffsDualRegisterElectricity(
                dayUnitRate = it._A?.direct_debit_monthly?.day_unit_rate_inc_vat,
                nightUnitRate = it._A?.direct_debit_monthly?.night_unit_rate_inc_vat,
                standingCharge = it._A?.direct_debit_monthly?.standing_charge_inc_vat
            )
        }

    private fun mapSingleRegisterElectricity(singleRegisterElectricityTariffs: SingleRegisterElectricityTariffs?): TariffsSingleRegisterElectricity? =
        singleRegisterElectricityTariffs?.let {
            TariffsSingleRegisterElectricity(
                standingCharge = it._A?.direct_debit_monthly?.standing_charge_inc_vat,
                standardUnitRate = it._A?.direct_debit_monthly?.standard_unit_rate_inc_vat
            )
        }
}