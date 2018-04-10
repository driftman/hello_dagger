package com.elbaz.mydaggerapplication.ui.base;

/**
 * Created by abk on 31/03/2018.
 */

public class BaseContract {

    public interface IMvpView {

        void showLoading();

        void hideLoading();

        void showMessage(String msg);

    }

    public interface IMvpPresenter<V extends IMvpView> {

        void onAttach(V view);

        void onDetach();

        void onViewInitialized();

    }

}
