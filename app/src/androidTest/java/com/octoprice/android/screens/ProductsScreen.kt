package com.octoprice.android.screens

import com.octoprice.android.R
import com.octoprice.android.testhelpers.checkTextOnRecycler
import com.octoprice.android.testhelpers.clickItemOnRecycler

internal class ProductsScreen {
    private val productsList = R.id.productsList

    fun checkPositionHasText(text: String, position: Int) {
        checkTextOnRecycler(productsList, text, position)
    }

    fun clickPosition(position: Int) {
        clickItemOnRecycler(productsList, position)
    }
}