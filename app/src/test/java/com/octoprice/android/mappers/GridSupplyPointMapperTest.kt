package com.octoprice.android.mappers

import com.octoprice.android.SampleData
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class GridSupplyPointMapperTest {
    lateinit var gridSupplyPointMapper: GridSupplyPointMapper

    @Before
    fun setUp() {
        gridSupplyPointMapper = GridSupplyPointMapper()
    }

    @Test
    fun `toDomain() maps correctly when single group`() {
        val expectedGroups = "_A"
        val groups = gridSupplyPointMapper.toDomain(SampleData.gridSupplyPointsResponseSingle).groups

        assertEquals(expectedGroups, groups)
    }

    @Test
    fun `toDomain() maps correctly when multiple groups`() {
        val expectedGroups = "_A, _C, _G"
        val groups = gridSupplyPointMapper.toDomain(SampleData.gridSupplyPointsResponseMultiple).groups

        assertEquals(expectedGroups, groups)
    }

    @Test
    fun `toDomain() maps correctly when no groups`() {
        val expectedGroups = ""
        val groups = gridSupplyPointMapper.toDomain(SampleData.gridSupplyPointsResponseNone).groups

        assertEquals(expectedGroups, groups)
    }
}