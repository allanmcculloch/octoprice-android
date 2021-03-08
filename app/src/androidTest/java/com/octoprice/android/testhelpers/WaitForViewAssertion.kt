package com.octoprice.android.testhelpers

import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.util.HumanReadables
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matcher
import java.util.concurrent.TimeoutException

class WaitForViewAssertion
private constructor(
    @param:IdRes private val mViewId: Int, private val mMillis: Long,
    private val matcher: Matcher<View>
) : ViewAction {

    override fun getConstraints(): Matcher<View> = ViewMatchers.withId(mViewId)

    override fun getDescription() =
        "$matcher on ${
            InstrumentationRegistry.getInstrumentation().context.resources.getResourceName(
                mViewId
            )
        }"

    override fun perform(uiController: UiController, view: View) {
        uiController.loopMainThreadUntilIdle()

        val startTime = System.currentTimeMillis()
        val endTime = startTime + mMillis

        do {
            if (matcher.matches(view)) {
                return
            }

            uiController.loopMainThreadForAtLeast(150)
        } while (System.currentTimeMillis() < endTime)


        throw PerformException.Builder()
            .withActionDescription(description)
            .withViewDescription(HumanReadables.describe(view))
            .withCause(TimeoutException())
            .build()
    }

    companion object {
        fun waitForViewAssertion(@IdRes viewId: Int, millis: Long, viewAssertion: Matcher<View>) =
            WaitForViewAssertion(viewId, millis, viewAssertion)
    }
}