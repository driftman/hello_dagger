package com.elbaz.mydaggerapplication.di.component;

import com.elbaz.mydaggerapplication.di.SUserScope;
import com.elbaz.mydaggerapplication.di.module.ScreenUserLoginModule;
import com.elbaz.mydaggerapplication.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by abk on 01/04/2018.
 */

@SUserScope
@Subcomponent(modules = {ScreenUserLoginModule.class})
public interface ScreenUserLoginComponent {

    void inject(MainActivity activity);
}
