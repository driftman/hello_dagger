package com.elbaz.mydaggerapplication.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elbaz.mydaggerapplication.MainApplication;
import com.elbaz.mydaggerapplication.R;
import com.elbaz.mydaggerapplication.data.network.UserService;
import com.elbaz.mydaggerapplication.data.network.model.User;
import com.elbaz.mydaggerapplication.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.IMainView {

    @Inject
    public MainPresenter mainPresenter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Injecting dependencies
        ((MainApplication) getApplication()).plusUserComponent();
        ((MainApplication) getApplication()).plusSUserComponent().inject(this);
        // Binding views
        bindViews();
        // Initializing views
        initViews();
        mainPresenter.onAttach(this);
        setUp();
    }

    @Override
    public void showUserList(List<User> users) {
        UserListAdapter adapter = new UserListAdapter(users, new UserListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User user) {
                showMessage(user.toString());
            }
        });
        recyclerView.setAdapter(adapter);
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
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDetach();
        ((MainApplication) getApplication()).clearSUserComponent();
        super.onDestroy();
    }
}
