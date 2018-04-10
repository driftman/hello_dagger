package com.elbaz.mydaggerapplication.ui.main;

import com.elbaz.mydaggerapplication.data.network.model.User;
import com.elbaz.mydaggerapplication.ui.base.BaseContract;

import java.util.List;

/**
 * Created by abk on 31/03/2018.
 */

public class MainContract {

    public interface IMainPresenter<V extends IMainView> extends BaseContract.IMvpPresenter<V> {

    }

    public interface IMainView extends BaseContract.IMvpView {
        void showUserList(List<User> user);
    }
}
