package com.seratic;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.seratic.api.ApiClient;
import com.seratic.databinding.ActivityRegisterUserBinding;


import com.seratic.models.Usuario;
import com.seratic.net.Response;
import com.seratic.net.UserClient;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;


public class RegisterUser extends AppCompatActivity implements Callback<Response> {

    ActivityRegisterUserBinding binding;
    UserClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_user);
        binding.setHandler(this);
        client =  ((ApiClient)getApplication()).retrofit.create(UserClient.class);
    }

    public void regis(){
        String cedula =  binding.cedula.getText().toString();
        String nombre =  binding.nombre.getText().toString();
        String apellido =  binding.apellido.getText().toString();
        String usuario =  binding.username.getText().toString();
        String clave =  binding.pass.getText().toString();
        Date fecha = new Date();
        String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fecha);
        Usuario user = new Usuario(cedula,nombre,apellido,usuario,"basico",clave,date);

        Call<Response> request = client.regisUser(user);
        request.enqueue(this);
    }

    @Override
    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
        Response res = response.body();
        Toast.makeText(this, R.string.regis_validate, Toast.LENGTH_SHORT).show();
        if(res.isExitoso()){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, R.string.regis_error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Response> call, Throwable t) {
        Toast.makeText(this,t.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
