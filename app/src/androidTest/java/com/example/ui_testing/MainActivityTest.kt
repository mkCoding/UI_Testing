package com.example.ui_testing

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    //Create UI Test

    //Test if we launch the activity and if it is in view
    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launch the activity
        onView(withId(R.id.main)).check(matches(isDisplayed())) //check if the activity is displayed
    }

    //Test visibility of the title and next button [2 things will be checked within this test]
    @Test
    fun test_visibility_title_next_button() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //Check the title is displayed
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))

        //Check if next button is displayed
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed())) //isDisplayed() for visibility
    }

    @Test
    fun test_isTitleTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity))) //withText check if text of element matches
    }

    //Test Navigation from MainActivity to SecondaryActivity
    @Test
    fun test_navSecondaryActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launch the activity
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_backPressToMainActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launch the activity
        onView(withId(R.id.button_next_activity)).perform(click()) //click button
        onView(withId(R.id.secondary)).check(matches(isDisplayed())) //navigate to second activity

        onView(withId(R.id.button_back)).perform(click()) //press back button
        //pressBack() //press back button on the actual device rather than button in main activity
        onView(withId(R.id.main)).check(matches(isDisplayed())) //Main Activity is displayed





    }
}