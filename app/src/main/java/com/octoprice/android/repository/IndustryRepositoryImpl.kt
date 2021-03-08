package com.octoprice.android.repository

import com.octoprice.android.domain.model.GridSupplyPoints
import com.octoprice.android.mappers.GridSupplyPointMapper
import com.octoprice.android.network.OctopusApiService

class IndustryRepositoryImpl(
    private val octopusApiService: OctopusApiService,
    private val gridSupplyPointMapper: GridSupplyPointMapper
) : IndustryRepository {
    override suspend fun getGridSupplyPoints(postCode: String): GridSupplyPoints {
        val response = octopusApiService.octopusClient.getIndustryGridSupplyPoints(postCode)
        val responseBody = response.body()  //TODO: Error handling return success / error
        return gridSupplyPointMapper.toDomain(responseBody)
    }
}