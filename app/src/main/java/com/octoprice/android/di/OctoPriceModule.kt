package com.octoprice.android.di
import com.octoprice.android.ui.industry.IndustryViewModel
import com.octoprice.android.ui.products.ProductsViewModel
import com.octoprice.android.ui.settings.SettingsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val octoPriceModule = module {

    viewModel { ProductsViewModel() }
    viewModel { IndustryViewModel() }
    viewModel { SettingsViewModel() }
}

