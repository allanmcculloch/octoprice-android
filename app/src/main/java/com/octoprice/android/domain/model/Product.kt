package com.octoprice.android.domain.model

import java.io.Serializable

data class Product(
    val availableFrom: String?,
    val availableTo: String?,
    val brand: String?,
    val code: String,
    val description: String?,
    val displayName: String?,
    val fullName: String?,
    val isBusiness: Boolean,
    val isGreen: Boolean,
    val isPrepay: Boolean,
    val isRestricted: Boolean,
    val isTracker: Boolean,
    val isVariable: Boolean,
    val term: Int?,
    val sampleProductRates : SampleProductRates? = null,
    val dualRegisterElectricity: TariffsDualRegisterElectricity? = null,
    val singleRegisterElectricity: TariffsSingleRegisterElectricity? = null
) : Serializable