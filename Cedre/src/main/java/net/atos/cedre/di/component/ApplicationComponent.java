package net.atos.cedre.di.component;

import net.atos.cedre.di.module.ApplicationModule;
import net.atos.cedre.di.module.NetworkModule;
import net.atos.cedre.di.module.UserModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abk on 31/03/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    UserComponent plusUserComponent(UserModule userModule);
}
