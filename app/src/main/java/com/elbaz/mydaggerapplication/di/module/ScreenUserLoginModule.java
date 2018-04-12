package com.elbaz.mydaggerapplication.di.module;

import com.elbaz.mydaggerapplication.data.network.UserService;
import com.elbaz.mydaggerapplication.di.SUserScope;
import com.elbaz.mydaggerapplication.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abk on 01/04/2018.
 */

@Module
public class ScreenUserLoginModule {

    public ScreenUserLoginModule() {}

    @Provides @SUserScope
    MainPresenter provideMainPresenter(UserService userService) {
        return new MainPresenter(userService);
    }
}
