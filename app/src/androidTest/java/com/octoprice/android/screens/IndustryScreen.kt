package com.octoprice.android.screens

import androidx.test.espresso.matcher.ViewMatchers
import com.octoprice.android.R
import com.octoprice.android.testhelpers.click
import com.octoprice.android.testhelpers.typeText
import com.octoprice.android.testhelpers.waitForMatcher
import org.hamcrest.Matchers

internal class IndustryScreen {
    private val postCodeEntry = R.id.postCodeEditText
    private val searchButton = R.id.searchButton
    private val gridSupplyPointResult = R.id.grid_supply_point_result

    fun enterPostCode(postCode: String) {
        postCodeEntry.typeText(postCode)
    }

    fun clickSearch() {
        searchButton.click()
    }

    fun checkGridSupplyPointResult(text: String) {
        gridSupplyPointResult.waitForMatcher(
            Matchers.allOf(
                ViewMatchers.isDisplayed(),
                ViewMatchers.withText(Matchers.containsString(text))
            )
        )
    }
}