package com.octoprice.android.screens

import androidx.test.espresso.matcher.ViewMatchers
import com.octoprice.android.R
import com.octoprice.android.testhelpers.checkHasText
import com.octoprice.android.testhelpers.waitForMatcher
import org.hamcrest.Matchers

internal class ProductsDetailsScreen {
    private val productName = R.id.productName
    private val singleRegisterElectricityStandardUnitRate =
        R.id.singleRegisterElectricityStandardUnitRate

    fun checkProductNameHasText(text: String) {
        productName.checkHasText(text)
    }

    fun checkSingleRegisterElectricityStandardUnitRate(text: String) {
        singleRegisterElectricityStandardUnitRate.waitForMatcher(
            Matchers.allOf(
                ViewMatchers.isDisplayed(),
                ViewMatchers.withText(Matchers.containsString(text))
            )
        )
    }
}