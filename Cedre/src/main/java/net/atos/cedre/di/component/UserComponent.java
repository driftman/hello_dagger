package net.atos.cedre.di.component;

import net.atos.cedre.di.UserScope;
import net.atos.cedre.di.module.ScreenUserLoginModule;
import net.atos.cedre.di.module.UserModule;

import dagger.Subcomponent;

/**
 * Created by abk on 31/03/2018.
 */

@UserScope
@Subcomponent(modules = {UserModule.class})
public interface UserComponent {

    ScreenUserLoginComponent plusScreenUserLoginComponent(ScreenUserLoginModule sUserModule);
}
