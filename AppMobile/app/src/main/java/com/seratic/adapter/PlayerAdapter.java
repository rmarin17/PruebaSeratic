package com.seratic.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seratic.models.Jugador;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerHolder>{


    public interface OnPlayerListener{
        void onPlayerClick(int position);
    }

    LayoutInflater inflater;
    List<Jugador> data;
    OnPlayerListener listener;

    public PlayerAdapter(LayoutInflater inflater, List<Jugador> data, OnPlayerListener listener) {
        this.inflater = inflater;
        this.data = data;
        this.listener = listener;
    }

    @Override
    public PlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_event, parent, false);
        return new PlayerHolder(v);
    }

    @Override
    public void onBindViewHolder(PlayerHolder holder, int position) {

        holder.binding.setEvent(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void onItemClick(int position){
        listener.onPlayerClick(position);
    }


    static class PlayerHolder extends RecyclerView.ViewHolder{

        TemplateEventBinding binding;

        public EventHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
