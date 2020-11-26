package com.example.hw1.database;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw1.R;

import java.util.List;

public class WeatherRecyclerAdapter extends
    RecyclerView.Adapter<WeatherRecyclerAdapter.ViewHolder>{

    private Activity activity;

    private WeatherSource weatherSource;

    private long menuPosition;

    public WeatherRecyclerAdapter(WeatherSource weatherSource, Activity activity) {
        this.activity = activity;
        this.weatherSource = weatherSource;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherRecyclerAdapter.ViewHolder holder, int position) {
        List<WeatherStore> weatherStores = weatherSource.getWeatherStore();
        WeatherStore weatherStore = weatherStores.get(position);
        holder.txtItemWeather.setText(String.format("%s %s %s гр.", weatherStore.dateTime, weatherStore.cityName, weatherStore.temperature));
       }

    @Override
    public int getItemCount() {
        return (int) weatherSource.getCountWeatherStore();
    }



    public long getMenuPosition() {
        return menuPosition;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemWeather;
        View cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView;
            txtItemWeather = cardView.findViewById(R.id.txtItemWeather);
        }
    }

}
