package com.example.hw1;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class GettingWeatherRetrofit {

    private String currentCity;
    private final TextView temperature;
    private final TextView windSpeed;
    private final TextView humidity;
    private final Context context;

    public GettingWeatherRetrofit(String currentCity, Context context, TextView temperature, TextView windSpeed, TextView humidity) {
        this.currentCity = currentCity;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.context = context;
    }

    public void getWeather() {
        try {
            String WEATHER_URL_END = "&appid=";
            String WEATHER_URL_START = "https://api.openweathermap.org/data/2.5/weather?q=";
            String API_KEY = "0df31282d60ddb7c0c246690e01e8a84";
            final URL uri = new URL(WEATHER_URL_START + currentCity + WEATHER_URL_END + API_KEY);
            final Handler handler = new Handler();

            new Thread(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void run() {
                    UrlData urlData = new UrlData(handler);
                    String result = urlData.getUrlData(uri, context);
                    Gson gson = new Gson();
                    final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            putToView(weatherRequest);
                        }
                    });
                }
            }).start();
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void putToView(WeatherRequest weatherRequest) {
        temperature.setText("Температура: " + weatherRequest.getMain().getTemp());
        windSpeed.setText("Скорость ветра: " + weatherRequest.getWind().getSpeed());
        humidity.setText("Влажность: " + weatherRequest.getMain().getHumidity());

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getLines(BufferedReader in) {
        return in.lines().collect(Collectors.joining("\n"));

    }

}
