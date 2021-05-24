package com.example.todo_12;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)

public class spinnerSelectionTest {

    @Rule
    public ActivityScenarioRule<Order> mActivityRule = new ActivityScenarioRule(Order.class);

    @Test
    private String[]  useAppContext(int id)  {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        return appContext.getResources().getStringArray(id);

        /*assertEquals("com.example.todo_12", appContext.getPackageName());*/

    }

    @Test
    public void iterateSpinnerItems(){
        String[] myArray = useAppContext(R.array.array_label);

        int size = myArray.length;

        for (int i=0; i<size; i++){
            onView(withId(R.id.spinner)).perform(click());

            onData(is(myArray[i])).perform(click());

            onView(withId(R.id.textView7)).check(matches(withText(containsString(myArray[i]))));
        }
    }




}


