package com.seratic.net;

import com.seratic.models.Jugador;
import com.seratic.models.Usuario;
import com.seratic.models.Voto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PlayerClient {

    @GET("/getPlayers")
    Call<List<Jugador>> getEvent();

    @POST("/voto")
    Call<Response> login(@Body Voto voto);
}
