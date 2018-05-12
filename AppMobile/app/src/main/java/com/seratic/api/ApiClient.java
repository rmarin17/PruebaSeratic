package com.seratic.api;

import android.app.Application;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RicardoM on 10/05/2018.
 */

public class ApiClient extends Application{

    public Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit =  new Retrofit.Builder()
                //.baseUrl("http://10.0.2.2:3000")  //se usa esta url para el simulador de android
                .baseUrl("http://192.168.0.39:8080") //se coloca la direccion del servidor
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

    }
}
