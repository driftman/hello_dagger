package net.atos.cedre.di.module;

import net.atos.cedre.data.network.UserService;
import net.atos.cedre.di.SUserScope;
import net.atos.cedre.ui.main.MainPresenter;

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
