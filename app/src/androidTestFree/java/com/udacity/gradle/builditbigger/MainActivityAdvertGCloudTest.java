package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;

/**
 * Run on paidDebug build variant
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityAdvertGCloudTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncGCloudResponse() throws Exception {
        onView(withId(R.id.btn_tell_joke)).perform(click());

        mActivityActivityTestRule.getActivity().mEndpointsAsyncTask.get();

        onView(allOf(withContentDescription("Interstitial close button"), isDisplayed()))
                .perform(click());

//        onView(withId(R.id.tv_joke))
  //              .check(matches(not(withText(""))));
    }
}