package com.octoprice.android.network.model.gridsupplypoint

data class GridSupplyPointsResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<GridSupplyPointGroupId>
)