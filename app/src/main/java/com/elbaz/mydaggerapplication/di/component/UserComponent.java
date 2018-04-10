package com.elbaz.mydaggerapplication.di.component;

import android.content.Context;

import com.elbaz.mydaggerapplication.data.network.UserService;
import com.elbaz.mydaggerapplication.di.UserScope;
import com.elbaz.mydaggerapplication.di.module.SUserModule;
import com.elbaz.mydaggerapplication.di.module.UserModule;
import com.elbaz.mydaggerapplication.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by abk on 31/03/2018.
 */

@UserScope
@Subcomponent(modules = {UserModule.class})
public interface UserComponent {

    SUserComponent plusSUserComponent(SUserModule sUserModule);
}
