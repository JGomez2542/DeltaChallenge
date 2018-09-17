package com.example.admin.deltachallenge;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.admin.deltachallenge.ui.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecyclerViewFragmentJava {


    @Before
    public void setup() throws InterruptedException {

        activityTestRule.getActivity()
                .getFragmentManager().beginTransaction().commit();

        Thread.sleep(3000);

    }

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testRecyclerViewCountList() {

        onView(withId(R.id.rvNumbers))
                .check(new RecyclerViewItemCountAssertion(40));

    }

    @Test
    public void averageIsNotEmpty() {

        onView(withId(R.id.tvDisplayedNumber)).check(matches(not(withText(""))));

    }


    @After
    public void tearUp() {


    }
}



