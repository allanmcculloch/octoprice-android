package com.octoprice.android.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.octoprice.android.R

internal class TabMenu {
    fun openProductsMenu() {
        onView(withId(R.id.navigation_products)).perform(click())
    }

    fun openIndustryMenu() {
        onView(withId(R.id.navigation_industry)).perform(click())
    }

    fun openSettingsMenu() {
        onView(withId(R.id.navigation_settings)).perform(click())
    }
}