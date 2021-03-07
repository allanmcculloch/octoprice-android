package com.octoprice.android.domain.model

data class TariffsDualRegisterElectricity(
    val dayUnitRate: Double?,
    val nightUnitRate: Double?,
    val standingCharge: Double?
)