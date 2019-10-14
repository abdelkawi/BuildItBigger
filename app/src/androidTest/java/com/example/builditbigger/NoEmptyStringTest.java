package com.example.builditbigger;


import android.util.Log;

import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.displayjokelib.DisplayJokeActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static java.security.AccessController.getContext;

/**
 * Created by Matteo on 30/06/2015.
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class NoEmptyStringTest  {

    @Test
    public void test() {
        try {
           String result = new EndpointsAsyncTask().execute().get();
            Log.d("", "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
