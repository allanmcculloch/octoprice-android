package com.octoprice.android.network.model.product

data class SampleConsumption(
    val dual_fuel_dual_rate: DualFuelDualRate?,
    val dual_fuel_single_rate: DualFuelSingleRate?,
    val electricity_dual_rate: ElectricityDualRate?,
    val electricity_single_rate: ElectricitySingleRate?
)