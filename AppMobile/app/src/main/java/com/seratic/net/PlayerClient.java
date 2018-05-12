package com.seratic.net;

import com.seratic.models.Jugador;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlayerClient {

    @GET("/getPlayers")
    Call<List<Jugador>> getEvent();
}
