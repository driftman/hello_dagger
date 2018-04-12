package com.elbaz.mydaggerapplication;

import com.elbaz.mydaggerapplication.di.UserMockModule;
import com.elbaz.mydaggerapplication.di.component.UserComponent;

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
