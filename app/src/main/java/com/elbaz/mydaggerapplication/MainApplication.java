package com.elbaz.mydaggerapplication;

import android.app.Application;

import com.elbaz.mydaggerapplication.di.component.ApplicationComponent;
import com.elbaz.mydaggerapplication.di.component.DaggerApplicationComponent;
import com.elbaz.mydaggerapplication.di.component.SUserComponent;
import com.elbaz.mydaggerapplication.di.component.UserComponent;
import com.elbaz.mydaggerapplication.di.module.ApplicationModule;
import com.elbaz.mydaggerapplication.di.module.NetworkModule;
import com.elbaz.mydaggerapplication.di.module.SUserModule;
import com.elbaz.mydaggerapplication.di.module.UserModule;

import java.io.File;

/**
 * Created by abk on 29/03/2018.
 */

public class MainApplication extends Application {

    ApplicationComponent applicationComponent;
    UserComponent userComponent;
    SUserComponent sUserComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(new File(getCacheDir(), "responses")))
                .build();

    }

    public UserComponent plusUserComponent() {
        if(userComponent == null) {
            userComponent = applicationComponent
                    .plusUserComponent(new UserModule());
        }
        return userComponent;
    }

    public void clearUserComponent() {
        userComponent = null;
    }

    public SUserComponent plusSUserComponent() {
        if(sUserComponent == null) {
            sUserComponent = userComponent
                    .plusSUserComponent(new SUserModule());
        }
        return sUserComponent;
    }

    public void clearSUserComponent() {
        sUserComponent = null;
    }

}