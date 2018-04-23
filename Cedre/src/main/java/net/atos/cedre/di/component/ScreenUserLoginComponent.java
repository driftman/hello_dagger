package net.atos.cedre.di.component;

import net.atos.cedre.di.SUserScope;
import net.atos.cedre.di.module.ScreenUserLoginModule;
import net.atos.cedre.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by abk on 01/04/2018.
 */

@SUserScope
@Subcomponent(modules = {ScreenUserLoginModule.class})
public interface ScreenUserLoginComponent {

    void inject(MainActivity activity);
}
