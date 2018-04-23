package net.atos.cedre;

import net.atos.cedre.di.UserMockModule;

import net.atos.cedre.di.component.UserComponent;

/**
 * Created by abk on 12/04/2018.
 */

public class TestMainApplication extends MainApplication {

    @Override
    public UserComponent plusUserComponent() {
        if(userComponent == null) {
            userComponent = applicationComponent
                    .plusUserComponent(new UserMockModule());
        }
        return userComponent;
    }

}
