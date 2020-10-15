package com.example.hw1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CityViewHolder extends RecyclerView.ViewHolder {

    private TextView txtItemWeather;






    public CityViewHolder(@NonNull View itemView) {
        super(itemView);


    }


     void bind(String city, OnCityClickListener onCityClickListener) {
        txtItemWeather = itemView.findViewById(R.id.txtViewCity);
        txtItemWeather.setText(city);
        txtItemWeather.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (onCityClickListener != null) {
                    onCityClickListener.onClicked(city);
                }
            }
        });

    }
}
