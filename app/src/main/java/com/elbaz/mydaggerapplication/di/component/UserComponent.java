package com.elbaz.mydaggerapplication.di.component;

import com.elbaz.mydaggerapplication.di.UserScope;
import com.elbaz.mydaggerapplication.di.module.ScreenUserLoginModule;
import com.elbaz.mydaggerapplication.di.module.UserModule;

import dagger.Subcomponent;

/**
 * Created by abk on 31/03/2018.
 */

@UserScope
@Subcomponent(modules = {UserModule.class})
public interface UserComponent {

    ScreenUserLoginComponent plusScreenUserLoginComponent(ScreenUserLoginModule sUserModule);
}
