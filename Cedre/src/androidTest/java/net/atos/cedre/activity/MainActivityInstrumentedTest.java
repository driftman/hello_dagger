package net.atos.cedre.activity;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import net.atos.cedre.ui.main.MainActivity;

import net.atos.cedre.R;
import com.atos.cedre.utils.TestUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.action.ViewActions.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void loginSuccessTest() {
        // initializing the views
        ViewInteraction editTextUsername = onView(withId(R.id.edit_text_username));
        ViewInteraction editTextPassword = onView(withId(R.id.edit_text_password));
        ViewInteraction buttonLogin = onView(withId(R.id.button_login));
        // filling the form with valid credentials
        editTextUsername.perform(typeText("username"));
        TestUtils.hideKeyboard();
        editTextPassword.perform(typeText("password"));
        TestUtils.hideKeyboard();
        // submitting form
        buttonLogin.perform(click());
        // checking
        editTextUsername.check(matches(TestUtils.hasNoErrorText()));
        editTextPassword.check(matches(TestUtils.hasNoErrorText()));
    }

    @Test
    public void loginFailedTest() {
        // initializing the views
        ViewInteraction editTextUsername = onView(withId(R.id.edit_text_username));
        ViewInteraction editTextPassword = onView(withId(R.id.edit_text_password));
        ViewInteraction buttonLogin = onView(withId(R.id.button_login));
        // filling the form with invalid credentials
        editTextUsername.perform(typeText("hacker"));
        TestUtils.hideKeyboard();
        editTextPassword.perform(typeText("hacker"));
        TestUtils.hideKeyboard();
        // submitting form
        buttonLogin.perform(click());
        // checking
        editTextUsername.check(matches(hasErrorText("Nom d\'utilisateur invalide.")));
        editTextPassword.check(matches(hasErrorText("Mot de passe invalide.")));
    }
}
