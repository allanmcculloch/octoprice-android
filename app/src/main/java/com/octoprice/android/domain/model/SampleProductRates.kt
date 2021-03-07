package com.octoprice.android.domain.model

data class SampleProductRates(
    val electricitySingleRate: Int? = 0,
    val electricityDualRateDay: Int? = 0,
    val electricityDualRateNight: Int? = 0,
    val dualFuelSingleRateElectricity: Int? = 0,
    val dualFuelSingleRateGas: Int? = 0
)