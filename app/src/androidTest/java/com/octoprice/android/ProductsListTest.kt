package com.octoprice.android

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.octoprice.android.screens.ProductsScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductsListTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private val productsScreen = ProductsScreen()

    @Test
    fun checkProductsListLoads() {
        //TODO: handle network delay with Idling Resource and setup MockWebServer
        Thread.sleep(3000)

        productsScreen.checkPositionHasText(
            "Affect 12M Fixed February 2021 v1",  //This will break if data changes!
            0
        )

        productsScreen.checkPositionHasText(
            "Affect Standard Tariff October 2020 v1", //This will break if data changes!
            2
        )
    }
}