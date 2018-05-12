package com.seratic.net;

import com.seratic.models.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by RicardoM on 10/05/2018.
 */

public interface UserClient {

    @POST("/login")
    Call<Response> login(@Body Usuario user);

    @POST("/newUser")
    Call<Response> regisUser(@Body Usuario user);

}
