package com.example.hw1;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class GettingWeather {

    private final String API_KEY = "0df31282d60ddb7c0c246690e01e8a84";
    private final String WEATHER_URL_START = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String WEATHER_URL_END = "&appid=";
    private String CurrentCity;
    private TextView temperature;
    private TextView windSpeed;
    private TextView humidity;
    private Context context;

    public GettingWeather(String currentCity, Context context, TextView temperature, TextView windSpeed, TextView humidity) {
        CurrentCity = currentCity;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.context = context;
    }

    public void getWeather() {
        try {
            final URL uri = new URL(WEATHER_URL_START + CurrentCity + WEATHER_URL_END + API_KEY);
            final Handler handler = new Handler();
            new Thread(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void run() {
                    HttpsURLConnection urlConnection = null;

                    try {
                        urlConnection = (HttpsURLConnection) uri.openConnection();
                        urlConnection.setRequestMethod("GET");
                        urlConnection.setReadTimeout(10000);
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        String result = getLines(in);

                        Gson gson = new Gson();

                        final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                putToView(weatherRequest);
                            }
                        });
                    } catch (IOException e) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "Ошибка Загруза данных", Toast.LENGTH_LONG).show();
                            }
                        });

                        e.printStackTrace();
                    }
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
