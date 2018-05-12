package com.seratic;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.seratic.adapter.PlayerAdapter;
import com.seratic.api.ApiClient;
import com.seratic.databinding.ActivityPlayersBinding;
import com.seratic.models.Jugador;
import com.seratic.net.PlayerClient;
import com.seratic.util.L;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Players extends AppCompatActivity implements PlayerAdapter.OnPlayerListener, DialogInterface.OnClickListener, Callback<com.seratic.net.Response> {

    ActivityPlayersBinding binding;
    PlayerAdapter adapter;
    PlayerClient client;

    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_players);
        binding.setHandler(this);

        L.data = new ArrayList<>();

        adapter =  new PlayerAdapter(getLayoutInflater(), L.data,this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));

        client = ((ApiClient)getApplication()).retrofit.create(PlayerClient.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadEvents();
    }

    private void loadEvents() {
        final Call<List<Jugador>> request =  client.getEvent();

        request.enqueue(new Callback<List<Jugador>>() {
            @Override
            public void onResponse(Call<List<Jugador>> call, Response<List<Jugador>> response) {
                if(response.isSuccessful()){
                    L.data.clear();
                    List<Jugador> data =  response.body();
                    for (Jugador j : data) {
                        L.data.add(j);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Jugador>> call, Throwable t) {
                Toast.makeText(Players.this, R.string.server_error,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void generateAlert() {
        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle("Votar Jugador")
                .setIcon(R.drawable.ic_warning)
                .setMessage(R.string.alert_msg)
                .setPositiveButton(R.string.ok,this)
                .setNegativeButton(R.string.cancel, this)
                .create();
        alert.show();
    }

    @Override
    public void onPlayerClick(int position) {
        id=position;
        generateAlert();
    }

    @Override
    public void onClick(DialogInterface dialog, int i) {
        if( i == DialogInterface.BUTTON_POSITIVE) {
            Intent intent = new Intent(this, Votar.class);
            intent.putExtra(Votar.EXTRA_POS, id);
            startActivity(intent);
        }
    }

    @Override
    public void onResponse(Call<com.seratic.net.Response> call, Response<com.seratic.net.Response> response) {

    }

    @Override
    public void onFailure(Call<com.seratic.net.Response> call, Throwable t) {

    }
}
