package com.example.todo_4;

import
        android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
/*import static androidx.test.espresso.Espresso.onView;*/

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    private static final String MESSAGE = "This is a test";
    private static final String REPLY_MESSAGE = "This is the reply";

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.todo_4", appContext.getPackageName());



    }
    @Test
    public void ActivityLaunch() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.button4)).perform(click());
        onView(withId(R.id.Replay_reached)).check(matches(isDisplayed()));

    }

    @Test
    public  void textInputOutput(){

        onView(withId(R.id.editText))
                .perform(typeText(MESSAGE));
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.display_msg)).check(matches(withText(MESSAGE)));

        onView(withId(R.id.Reply_txt))
                .perform(typeText(REPLY_MESSAGE));
        onView(withId(R.id.button4)).perform(click());
        onView(withId(R.id.Display_msg)).check(matches(withText(REPLY_MESSAGE)));
    }


}