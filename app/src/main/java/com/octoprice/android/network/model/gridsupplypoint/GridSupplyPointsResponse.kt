package com.octoprice.android.network.model.gridsupplypoint

data class GridSupplyPointsResponse(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<GridSupplyPointGroupId>
)