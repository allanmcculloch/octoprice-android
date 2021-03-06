package com.octoprice.android.network.model.product

data class DualFuelDualRate(
    val electricity_day: Int,
    val electricity_night: Int,
    val gas_standard: Int
)