package com.octoprice.android.network.model.product

data class DualRegisterElectricityTariffs(
    val _A: ADualRegisterElectricity?
)

data class ADualRegisterElectricity(
    val direct_debit_monthly: DirectDebitMonthlyDualRegisterElectricity?
)

data class DirectDebitMonthlyDualRegisterElectricity(
    val day_unit_rate_inc_vat: Double?,
    val night_unit_rate_inc_vat: Double?,
    val standing_charge_inc_vat: Double?
)