package net.atos.cedre.di.module;

import net.atos.cedre.data.network.IUserService;
import net.atos.cedre.data.network.UserService;
import net.atos.cedre.di.UserScope;

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
