package com.octoprice.android.ui.products

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.octoprice.android.SampleData
import com.octoprice.android.domain.usecase.GetProductUseCase
import io.mockk.coEvery
import io.mockk.mockk
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
class ProductDetailsViewModelTest {
    private lateinit var getProductUseCase: GetProductUseCase
    private lateinit var productDetailsViewModel: ProductDetailsViewModel

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()  // testing rule for arch components - livedata

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)  // run viewModelScope.launch on main thread

        getProductUseCase = mockk(relaxed = true)

        coEvery { getProductUseCase(SampleData.singleProduct.code) }.returns(SampleData.updatedProduct)

        productDetailsViewModel = ProductDetailsViewModel(getProductUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `loadData() provides product via livedata then updates with fresh data from the api`() {
        val productLiveData = productDetailsViewModel.product.test()

        productLiveData.assertNoValue()

        productDetailsViewModel.loadProduct(SampleData.singleProduct)

        productLiveData.awaitValue()
        productLiveData.assertValue(SampleData.singleProduct)
        productLiveData.awaitNextValue()
        productLiveData.assertValue(SampleData.updatedProduct)
    }
}