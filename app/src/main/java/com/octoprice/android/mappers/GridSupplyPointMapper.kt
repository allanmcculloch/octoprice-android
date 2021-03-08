package com.octoprice.android.mappers

import com.octoprice.android.domain.model.GridSupplyPoints
import com.octoprice.android.network.model.gridsupplypoint.GridSupplyPointsResponse
import java.util.*

class GridSupplyPointMapper : DomainMapper<GridSupplyPointsResponse?, GridSupplyPoints> {
    override fun toDomain(model: GridSupplyPointsResponse?): GridSupplyPoints {
        val groupsString =
            model?.results?.map { it.group_id }?.joinToString { it.toUpperCase(Locale.ENGLISH) }
        return GridSupplyPoints(groupsString)
    }
}