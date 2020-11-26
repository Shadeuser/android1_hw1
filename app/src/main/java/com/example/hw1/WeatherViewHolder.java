package com.example.hw1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    private TextView txtItemWeather;






    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);


    }


     void bind(String city, OnWeatherClickListener onWeatherClickListener) {
        txtItemWeather = itemView.findViewById(R.id.txtItemWeather);
        txtItemWeather.setText(city);
        txtItemWeather.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (onWeatherClickListener != null) {
                    onWeatherClickListener.onClicked(city);
                }
            }
        });

    }
}
