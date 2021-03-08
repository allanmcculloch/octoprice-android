package com.octoprice.android.testhelpers

import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.octoprice.android.testhelpers.WaitForViewAssertion.Companion.waitForViewAssertion
import org.hamcrest.Matcher
import org.hamcrest.Matchers

@IdRes
fun @receiver:IdRes Int.checkHasText(text: String) {
    onView(withId(this)).check(
        matches(
            Matchers.allOf(
                isDisplayed(),
                ViewMatchers.withText(Matchers.containsString(text))
            )
        )
    )
}

@IdRes
fun @receiver:IdRes Int.click() {
    onView(withId(this)).perform(androidx.test.espresso.action.ViewActions.click())
}

@IdRes
fun @receiver:IdRes Int.waitForMatcher(matcher: Matcher<View>, millis: Long = 10000) {
    onView(withId(this)).perform(waitForViewAssertion(this, millis, matcher))
}

@IdRes
fun @receiver:IdRes Int.typeText(text: String) {
    onView(withId(this)).perform(androidx.test.espresso.action.ViewActions.typeText(text))
}

@IdRes
fun @receiver:IdRes Int.checkIsVisible() {
    onView(withId(this)).check(matches(isDisplayed()))
}
