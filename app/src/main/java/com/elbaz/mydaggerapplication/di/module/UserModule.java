package com.elbaz.mydaggerapplication.di.module;

import com.elbaz.mydaggerapplication.data.network.IUserService;
import com.elbaz.mydaggerapplication.data.network.UserService;
import com.elbaz.mydaggerapplication.di.UserScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by abk on 31/03/2018.
 */

@Module
public class UserModule {

    public UserModule() {}

    @Provides @UserScope
    public UserService provideUserService(Retrofit retrofit) {
        return new UserService(retrofit.create(IUserService.class));
    }

}
