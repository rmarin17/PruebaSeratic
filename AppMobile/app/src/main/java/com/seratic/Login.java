package com.seratic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.seratic.api.ApiClient;
import com.seratic.databinding.ActivityLoginBinding;
import com.seratic.models.Usuario;
import com.seratic.net.Response;
import com.seratic.net.UserClient;

import retrofit2.Call;
import retrofit2.Callback;

public class Login extends AppCompatActivity implements Callback<Response> {

    ActivityLoginBinding binding;

    UserClient client;
    SharedPreferences preferences; //se utiliza sharepreferences para el mantenimiento de sesion
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);

        //se inicializa el uso de retrofit
        client =  ((ApiClient)getApplication()).retrofit.create(UserClient.class);

        //Inicialización sharepreferences
        preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        //se comprueba que no se tenga sesion iniciada
        boolean logged = preferences.getBoolean("session", false);
        if (logged){
            Intent intent = new Intent(this, Players.class);
            startActivity(intent);
            finish();//para que aparezaca esta interfaz cuante este iniciada la sesion se finaliza el activity
        }
    }

    public void goToRegister(){
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);
    }

    public void login(){
        String usuario =  binding.user.getText().toString();
        String clave =  binding.pass.getText().toString();//la cave la autentica el servidor
        Usuario user = new Usuario(usuario, clave);

        Call<Response> request = client.login(user);
        request.enqueue(this);
    }

    @Override
    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
        Response res = response.body();
        Toast.makeText(this, R.string.login_validate, Toast.LENGTH_SHORT).show();
        if(res.isExitoso()){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("session", true);
            editor.apply();
            Intent intent = new Intent(this, Players.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, R.string.login_user_error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Response> call, Throwable t) {
        Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
