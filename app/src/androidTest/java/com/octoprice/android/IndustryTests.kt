package com.octoprice.android

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.octoprice.android.screens.IndustryScreen
import com.octoprice.android.screens.TabMenu
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IndustryTests {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private val industryScreen = IndustryScreen()
    private val tabMenu = TabMenu()

    @Test
    fun checkValidPostCode() {
        tabMenu.openIndustryMenu()

        val postCode = "E14 8RA"
        val expectedGroup = "_C"

        industryScreen.enterPostCode(postCode)
        industryScreen.clickSearch()
        industryScreen.checkGridSupplyPointResult("$postCode is in group $expectedGroup")
    }

    @Test
    fun checkInvalidPostCode() {
        tabMenu.openIndustryMenu()

        val postCode = "junkpc"

        industryScreen.enterPostCode(postCode)
        industryScreen.clickSearch()
        industryScreen.checkGridSupplyPointResult("$postCode is unknown")
    }

    @Test
    fun noPostCodeEnteredNoResultDisplayed() {
        tabMenu.openIndustryMenu()

        industryScreen.clickSearch()
        industryScreen.checkGridSupplyPointResult("")
    }
}