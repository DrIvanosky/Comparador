package com.comparador

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.comparador.views.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest_botonComparar() {

        Espresso.onView(
            ViewMatchers.withId(R.id.button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Son Iguales")
            )
        )
    }
}