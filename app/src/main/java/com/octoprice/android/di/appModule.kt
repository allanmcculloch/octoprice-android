package com.octoprice.android.di

import com.octoprice.android.domain.usecase.GetProductUseCase
import com.octoprice.android.mappers.ProductMapper
import com.octoprice.android.network.OctopusApiService
import com.octoprice.android.repository.ProductsRepository
import com.octoprice.android.repository.ProductsRepositoryImpl
import com.octoprice.android.ui.industry.IndustryViewModel
import com.octoprice.android.ui.products.ProductsViewModel
import com.octoprice.android.ui.settings.SettingsViewModel
import com.octoprice.android.domain.usecase.GetProductsUseCase
import com.octoprice.android.ui.products.ProductDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ProductsViewModel(get()) }
    viewModel { ProductDetailsViewModel(get()) }
    viewModel { IndustryViewModel() }
    viewModel { SettingsViewModel() }

    single { OctopusApiService() }

    // Use Cases
    single { GetProductsUseCase(get()) }
    single { GetProductUseCase(get()) }

    // Repos
    single<ProductsRepository> { ProductsRepositoryImpl(get(), get()) }

    // Mappers
    single { ProductMapper() }
}

