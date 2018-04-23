package net.atos.cedre.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import net.atos.cedre.MainApplication;
import com.atos.cedre.R;
import net.atos.cedre.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.IMainView, View.OnClickListener {

    private ProgressBar     progressBar;
    private Button          buttonLogin;
    private EditText        editTextUsername;
    private EditText        editTextPassword;

    @Inject
    public MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Injecting dependencies
        ((MainApplication) getApplication()).plusUserComponent();
        ((MainApplication) getApplication()).plusScreenUserLoginComponent().inject(this);
        // Binding views
        bindViews();
        // Initializing views
        initViews();
        mainPresenter.onAttach(this);
        setUp();
    }

    @Override
    public void showMessage(String msg) {
        super.showMessage(msg);
    }

    private void setUp() {
        mainPresenter.onViewInitialized();
    }

    private void bindViews() {
        setContentView(R.layout.activity_main);
        progressBar      = (ProgressBar)    findViewById(R.id.progress_bar);
        buttonLogin      = (Button)         findViewById(R.id.button_login);
        editTextUsername = (EditText)       findViewById(R.id.edit_text_username);
        editTextPassword = (EditText)       findViewById(R.id.edit_text_password);
    }

    private void initViews() {
        buttonLogin.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDetach();
        ((MainApplication) getApplication()).clearSUserComponent();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        mainPresenter.login(username, password);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void goToNextActivity() {
        showMessage("Logged in successfully!");
    }

    @Override
    public void formError() {
        editTextUsername.setError("Nom d'utilisateur invalide.");
        editTextPassword.setError("Mot de passe invalide.");
    }
}
