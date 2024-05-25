package com.example.ui_testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest{

    //An activity scenario doesn't need to be created in each test now
    @get:Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun test_isActivityInView() {
        //simply check if secondary activity is displayed when app runs
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    //Test that checks if Secondary Activity Title is displayed
    //Test that checks if back button is visible
    @Test
    fun test_visibility_title_back_button(){
        onView(withId(R.id.activity_secondary_title)).check(matches(isDisplayed())) //test Title displayed

        onView(withId(R.id.button_back)).check(matches(isDisplayed())) //test Back Button displayed
    }

    //Test that checks if Secondary Activity Title matches the expected title text "SecondaryActivity"
    @Test
    fun test_isTitleTextDisplayed(){
        onView(withId(R.id.activity_secondary_title)).check(matches(withText(R.string.text_secondaryactivity)))
    }



}