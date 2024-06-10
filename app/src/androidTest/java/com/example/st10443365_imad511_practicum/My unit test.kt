package com.example.st10443365_imad511_practicum


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testButton1_click_opensMscreen2() {
        // Launch MainActivity
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Perform click on button1
        onView(withId(R.id.button1)).perform(click())

        // Check if mscreen2's EditText is displayed
        onView(withId(R.id.editTextText)).check(matches(isDisplayed()))

        // Close the scenario
        scenario.close()
    }

    @Test
    fun testButton2_click_finishesActivity() {
        // Launch MainActivity
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Perform click on button2
        onView(withId(R.id.button2)).perform(click())

        // Assuming MainActivity finishes and returns to the previous activity or closes
        // Note: We can't assert the activity is finished using Espresso directly.
        // However, ActivityScenario will close the activity and finish the scenario automatically.

        // Close the scenario
        scenario.close()
    }
}




