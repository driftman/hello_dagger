package com.elbaz.mydaggerapplication.data.network;

import com.elbaz.mydaggerapplication.data.network.model.User;

import java.util.List;

import retrofit2.http.GET;

import rx.Observable;

/**
 * Created by abk on 30/03/2018.
 */

public interface IUserService {

    @GET("users")
    Observable<List<User>> getUserList();
}
