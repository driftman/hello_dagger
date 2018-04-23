package net.atos.cedre.ui.main;

import net.atos.cedre.ui.base.BaseContract;

/**
 * Created by abk on 31/03/2018.
 */

public class MainContract {

    public interface IMainPresenter<V extends IMainView> extends BaseContract.IMvpPresenter<V> {
        void login(String username, String password);
    }

    public interface IMainView extends BaseContract.IMvpView {
        void showProgressBar();
        void hideProgressBar();
        void goToNextActivity();
        void formError();
    }
}
