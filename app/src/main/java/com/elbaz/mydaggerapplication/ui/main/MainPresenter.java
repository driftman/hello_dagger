package com.elbaz.mydaggerapplication.ui.main;

import com.elbaz.mydaggerapplication.data.network.UserService;
import com.elbaz.mydaggerapplication.data.network.model.User;

import java.util.List;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by abk on 31/03/2018.
 */

public class MainPresenter<V extends MainContract.IMainView> implements MainContract.IMainPresenter<V> {

    private final UserService service;

    private CompositeSubscription subscriptions;

    private V view;

    public MainPresenter(UserService service) {
        this.service = service;
        subscriptions = new CompositeSubscription();
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
        subscriptions.unsubscribe();
    }

    @Override
    public void onViewInitialized() {
        Subscription subscription = service.getUserList(new UserService.GetUserListCallback() {
            @Override
            public void onSuccess(List<User> users) {
                view.showUserList(users);
            }

            @Override
            public void onError(String msg) {
                view.showMessage(msg);
            }
        });
        subscriptions.add(subscription);
    }
}
