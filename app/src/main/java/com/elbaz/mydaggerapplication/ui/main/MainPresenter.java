package com.elbaz.mydaggerapplication.ui.main;

import com.elbaz.mydaggerapplication.data.network.UserService;
import com.elbaz.mydaggerapplication.data.network.model.User;
import com.elbaz.mydaggerapplication.data.network.response.UserResponse;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by abk on 31/03/2018.
 */

public class MainPresenter<V extends MainContract.IMainView> implements MainContract.IMainPresenter<V> {

    private final UserService service;

    private Subscription subscription;

    private V view;

    public MainPresenter(UserService service) {
        this.service = service;
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
        if(subscription != null) subscription.unsubscribe();
    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void login(String username, String password) {
        view.showProgressBar();
        subscription = service.login(username, password)
                .subscribeOn(Schedulers.immediate())
                .observeOn(Schedulers.immediate())
                .subscribe(new Subscriber<UserResponse>() {
                    @Override
                    public void onCompleted() {
                        //
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideProgressBar();
                        view.formError();
                    }

                    @Override
                    public void onNext(UserResponse user) {
                        if(user.getCode() == 200) {
                            view.hideProgressBar();
                            view.goToNextActivity();
                        } else {
                            view.hideProgressBar();
                            view.formError();
                        }
                    }
                });
    }
}
