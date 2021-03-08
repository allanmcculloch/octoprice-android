package com.octoprice.android

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.octoprice.android.screens.ProductsDetailsScreen
import com.octoprice.android.screens.ProductsScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductDetailsTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private val productsScreen = ProductsScreen()
    private val productDetailsScreen = ProductsDetailsScreen()

    @Test
    fun checkProductDetailsPageLoadsWithData() {
        //TODO: handle network delay with Idling Resource and setup MockWebServer
        Thread.sleep(3000)

        val productName = "Affect 12M Fixed February 2021 v1"   //This will break if data changes!
        val singleRegisterElectricityStandardUnitRate = "17.136"  //This will break if data changes!

        productsScreen.checkPositionHasText(
            productName,
            0
        )

        productsScreen.clickPosition(0)

        productDetailsScreen.checkProductNameHasText(productName)
        productDetailsScreen.checkSingleRegisterElectricityStandardUnitRate(
            singleRegisterElectricityStandardUnitRate
        )
    }
}