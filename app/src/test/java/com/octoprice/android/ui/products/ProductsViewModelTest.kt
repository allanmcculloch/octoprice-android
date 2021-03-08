package com.octoprice.android.ui.products

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.octoprice.android.SampleData
import com.octoprice.android.domain.usecase.GetProductsUseCase
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
class ProductsViewModelTest {
    private lateinit var getProductsUseCase: GetProductsUseCase
    private lateinit var productsViewModel: ProductsViewModel

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()  // testing rule for arch components - livedata

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)  // run viewModelScope.launch on main thread

        getProductsUseCase = mockk(relaxed = true)

        coEvery { getProductsUseCase() }.returns(SampleData.products)

        productsViewModel = ProductsViewModel(getProductsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `loadProducts() provides products via livedata`() {
        val productsLiveData = productsViewModel.products.test()
        productsLiveData.assertNoValue()

        productsViewModel.loadProducts()

        productsLiveData.awaitValue()
        val products = productsLiveData.value().map { it.dataItem }

        assertEquals(SampleData.products.count(), products.count())
        assertEquals(SampleData.products, products)
    }
}