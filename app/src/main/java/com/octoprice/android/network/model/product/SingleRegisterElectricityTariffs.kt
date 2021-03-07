package com.octoprice.android.network.model.product

data class SingleRegisterElectricityTariffs(
    val _A: ASingleRegisterElectricity?
)

data class ASingleRegisterElectricity(
    val direct_debit_monthly: DirectDebitMonthlySingleRegisterElectricity?
)

data class DirectDebitMonthlySingleRegisterElectricity(
    val standard_unit_rate_inc_vat: Double?,
    val standing_charge_inc_vat: Double?
)