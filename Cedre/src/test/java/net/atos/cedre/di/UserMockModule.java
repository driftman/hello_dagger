package net.atos.cedre.di;

import net.atos.cedre.data.network.UserService;
import net.atos.cedre.data.network.response.UserResponse;
import net.atos.cedre.di.module.UserModule;

import retrofit2.Retrofit;
import rx.Observable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by abk on 12/04/2018.
 */

public class UserMockModule extends UserModule {

    @Override
    public UserService provideUserService(Retrofit retrofit) {
        UserService userService = mock(UserService.class);
        when(userService.login(
                "username",
                "password"))
                .thenReturn(Observable.just(new UserResponse(200, null)));
        when(userService.login(
                "hacker",
                "hacker"))
                .thenReturn(Observable.just(new UserResponse(401, null)));
        return userService;
    }
}
