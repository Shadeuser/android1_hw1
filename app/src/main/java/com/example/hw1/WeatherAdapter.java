package com.example.hw1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    private List<String> weatherList;
    private OnWeatherClickListener onWeatherClickListener;


    public void setOnWeatherClickListener(OnWeatherClickListener onWeatherClickListener) {
        this.onWeatherClickListener = onWeatherClickListener;
    }

    public void setWeatherList(List<String> weatherList) {
        this.weatherList = weatherList;
        notifyDataSetChanged();
    }


//    @NonNull
//    @Override
//    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new WeatherViewHolder (LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_weather, parent, false));
//    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WeatherViewHolder vwh = new  WeatherViewHolder (LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather, parent, false));

        return vwh;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        holder.bind(weatherList.get(position), onWeatherClickListener);
    }


    @Override
    public int getItemCount() {
        if (weatherList == null) {
            return 0;
        }
        return this.weatherList.size();

    }

}
