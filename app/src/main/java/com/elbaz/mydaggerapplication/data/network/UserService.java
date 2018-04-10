package com.elbaz.mydaggerapplication.data.network;

import com.elbaz.mydaggerapplication.data.network.model.User;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by abk on 30/03/2018.
 */

public class UserService {

    private final IUserService networkService;

    public UserService(IUserService networkService) {
        this.networkService = networkService;
    }

    public Subscription getUserList(final GetUserListCallback callback) {
        return networkService.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {
                        // ;)
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<User> users) {
                        callback.onSuccess(users);
                    }
                });
    }

    public interface GetUserListCallback {

        void onSuccess(List<User> users);

        void onError(String msg);
    }
}
