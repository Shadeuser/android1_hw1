package com.example.hw1.database;

import android.content.res.Resources;

import java.util.Random;

public class RandomWeather {
    private Resources resources;
    private Random rnd = new Random();

    public RandomWeather(Resources resources) {
        this.resources = resources;
    }

    public WeatherStore setRndUpdateWeatherStore(WeatherStore weatherStore) {
        weatherStore.cityName = "Бобруйск";
        weatherStore.dateTime = "21:01 2020";
        weatherStore.temperature = "-15";
        weatherStore.windSpeed = 10;
        weatherStore.humidity = 55;
        return weatherStore;
    }

    public WeatherStore setRndWeatherStore() {
        WeatherStore weatherStore = new WeatherStore();
        return setRndUpdateWeatherStore(weatherStore);

    }
}
