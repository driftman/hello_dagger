package net.atos.cedre;

import android.app.Application;

import net.atos.cedre.di.component.ApplicationComponent;
import com.atos.cedre.di.component.DaggerApplicationComponent;
import net.atos.cedre.di.component.ScreenUserLoginComponent;
import net.atos.cedre.di.component.UserComponent;
import net.atos.cedre.di.module.ApplicationModule;
import net.atos.cedre.di.module.NetworkModule;
import net.atos.cedre.di.module.ScreenUserLoginModule;
import net.atos.cedre.di.module.UserModule;

import java.io.File;

/**
 * Created by abk on 29/03/2018.
 */

public class MainApplication extends Application {

    ApplicationComponent applicationComponent;
    UserComponent userComponent;
    ScreenUserLoginComponent sUserComponent;

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

    public ScreenUserLoginComponent plusScreenUserLoginComponent() {
        if(sUserComponent == null) {
            sUserComponent = userComponent
                    .plusScreenUserLoginComponent(new ScreenUserLoginModule());
        }
        return sUserComponent;
    }

    public void clearSUserComponent() {
        sUserComponent = null;
    }

}
