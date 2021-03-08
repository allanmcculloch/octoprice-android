package com.octoprice.android.ui.industry

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.octoprice.android.SampleData
import com.octoprice.android.domain.model.GridSupplyPoints
import com.octoprice.android.domain.usecase.GetGridSupplyPointsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class IndustryViewModelTest {

    private val postCode = "E14 3TW"
    private val expectedSingleGroup = "_A"

    private lateinit var getGridSupplyPointsUseCase: GetGridSupplyPointsUseCase
    private lateinit var industryViewModel: IndustryViewModel

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()  // testing rule for arch components - livedata

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)  // run viewModelScope.launch on main thread

        getGridSupplyPointsUseCase = mockk(relaxed = true)

        coEvery { getGridSupplyPointsUseCase(postCode) }.returns(GridSupplyPoints(expectedSingleGroup))

        industryViewModel = IndustryViewModel(getGridSupplyPointsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `search() provides gridSupplyPoint via livedata`() {
        industryViewModel.postCode.value = postCode
        val gridSupplyPointLiveData = industryViewModel.gridSupplyPoint.test()
        gridSupplyPointLiveData.assertNoValue()

        industryViewModel.search()

        gridSupplyPointLiveData.awaitValue()

        val gridSupplyPoint = gridSupplyPointLiveData.value()

        assertEquals("$postCode is in group $expectedSingleGroup", gridSupplyPoint)
    }

    @Test
    fun `search() provides unknown via livedata when empty gridSupplyPoints`() {
        industryViewModel.postCode.value = postCode
        val gridSupplyPointLiveData = industryViewModel.gridSupplyPoint.test()
        gridSupplyPointLiveData.assertNoValue()

        coEvery { getGridSupplyPointsUseCase(postCode) }.returns(GridSupplyPoints(""))

        industryViewModel.search()

        gridSupplyPointLiveData.awaitValue()

        val gridSupplyPoint = gridSupplyPointLiveData.value()

        assertEquals("$postCode is unknown", gridSupplyPoint)
    }
}