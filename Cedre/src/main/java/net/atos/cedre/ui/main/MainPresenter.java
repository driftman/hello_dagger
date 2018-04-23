package net.atos.cedre.ui.main;

import net.atos.cedre.data.network.UserService;
import net.atos.cedre.data.network.response.UserResponse;

import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

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
