package com.example.st10443365_imad511_practicum



import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Mscreen2Test {

    @Test
    fun testCalculateAverage() {
        // Launch mscreen2 activity
        val scenario = ActivityScenario.launch(mscreen2::class.java)

        // Enter values and click calculate button
        onView(withId(R.id.editTextNumber)).perform(typeText("10"))
        onView(withId(R.id.editTextNumber2)).perform(typeText("20"))
        onView(withId(R.id.button4)).perform(click())

        // Check if the average is displayed correctly
        onView(withId(R.id.textView7)).check(matches(withText("Average: 15.0")))

        // Close the scenario
        scenario.close()
    }

    @Test
    fun testAddScreenData() {
        // Launch mscreen2 activity
        val scenario = ActivityScenario.launch(mscreen2::class.java)

        // Enter data and click add button
        onView(withId(R.id.editTextText)).perform(typeText("Monday"))
        onView(withId(R.id.editTextNumber)).perform(typeText("10"))
        onView(withId(R.id.editTextNumber2)).perform(typeText("20"))
        onView(withId(R.id.editText)).perform(typeText("Sunny"))
        onView(withId(R.id.button3)).perform(click())

        // Verify that the input fields are cleared
        onView(withId(R.id.editTextText)).check(matches(withText("")))
        onView(withId(R.id.editTextNumber)).check(matches(withText("")))
        onView(withId(R.id.editTextNumber2)).check(matches(withText("")))
        onView(withId(R.id.editText)).check(matches(withText("")))

        // Close the scenario
        scenario.close()
    }

    @Test
    fun testButton5_click_opensDetailedViewScreen() {
        // Launch mscreen2 activity
        val scenario = ActivityScenario.launch(mscreen2::class.java)

        // Add data first
        onView(withId(R.id.editTextText)).perform(typeText("Monday"))
        onView(withId(R.id.editTextNumber)).perform(typeText("10"))
        onView(withId(R.id.editTextNumber2)).perform(typeText("20"))
        onView(withId(R.id.editText)).perform(typeText("Sunny"))
        onView(withId(R.id.button3)).perform(click())

        // Click button5 to open DetailedViewScreen
        onView(withId(R.id.button5)).perform(click())

        // Check if DetailedViewScreen's tableLayout is displayed
        onView(withId(R.id.tableLayout)).check(matches(isDisplayed()))

        // Close the scenario
        scenario.close()
    }
}

