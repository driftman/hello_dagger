package com.elbaz.mydaggerapplication.data.network;


import com.elbaz.mydaggerapplication.data.network.response.UserResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import rx.Observable;

/**
 * Created by abk on 30/03/2018.
 */

public interface IUserService {

    @POST("login")
    @FormUrlEncoded
    Observable<UserResponse> login(@Field("username") String username, @Field("password")String password);
}
