package net.atos.cedre.activity;

import android.widget.Button;
import android.widget.EditText;

import com.atos.cedre.BuildConfig;
import com.atos.cedre.R;
import net.atos.cedre.TestMainApplication;
import net.atos.cedre.ui.main.MainActivity;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Soufiane ELBAZ on 10/04/2018.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = TestMainApplication.class)
public class MainActivityTest {

    private MainActivity mainActivity;
    private Button buttonLogin;
    private EditText editTextUsername;
    private EditText editTextPassword;

    @Before
    public void setUp() throws Exception {

        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();

        buttonLogin = (Button) mainActivity.findViewById(R.id.button_login);
        editTextUsername = (EditText) mainActivity.findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) mainActivity.findViewById(R.id.edit_text_password);

    }

    @Test
    public void activityShouldNotBeNull() {
        assertNotNull(mainActivity);
    }

    @Test
    public void shouldConnect() {
        // simulating user inputs
        editTextUsername.setText("username");
        editTextPassword.setText("password");
        // performing a click
        buttonLogin.performClick();
        // assertions
        assertThat("Not show error for Email field ", editTextUsername.getError(), is(CoreMatchers.nullValue()));
        assertThat("Not show error for Password field ", editTextPassword.getError(), is(CoreMatchers.nullValue()));
    }


    @Test
    public void shouldNotConnect() {
        // simulating user inputs
        editTextUsername.setText("hacker");
        editTextPassword.setText("hacker");
        // performing a click
        buttonLogin.performClick();
        // assertions
        assertThat("Show error for Email field ", editTextUsername.getError(), is(CoreMatchers.notNullValue()));
        assertThat("Show error for Password field ", editTextPassword.getError(), is(CoreMatchers.notNullValue()));
    }
}
