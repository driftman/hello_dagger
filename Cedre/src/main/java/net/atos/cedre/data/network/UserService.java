package net.atos.cedre.data.network;

import net.atos.cedre.data.network.response.UserResponse;

import rx.Observable;

/**
 * Created by abk on 30/03/2018.
 */

public class UserService {

    private final IUserService networkService;

    public UserService(IUserService networkService) {
        this.networkService = networkService;
    }

    public Observable<UserResponse> login(String username, String password) {
        return networkService.login(username, password);
    }

}
