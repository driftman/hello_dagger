package com.elbaz.mydaggerapplication;

import com.elbaz.mydaggerapplication.ui.main.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Soufiane ELBAZ on 10/04/2018.
 */

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {

        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();

    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(mainActivity);
    }
}
