package com.octoprice.android.repository

import com.octoprice.android.domain.model.GridSupplyPoints

interface IndustryRepository {
    suspend fun getGridSupplyPoints(postCode: String): GridSupplyPoints
}
