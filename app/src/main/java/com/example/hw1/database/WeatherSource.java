package com.example.hw1.database;

import java.util.List;

public class WeatherSource {

    private final WeatherDao weatherDao;
    private List<WeatherStore> weatherStore;

    public WeatherSource(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    public List<WeatherStore> getWeatherStore() {
        if (weatherStore == null) {
            loadWeatherStore();
        }
        return weatherStore;
    }

    public void loadWeatherStore() {
        weatherStore = weatherDao.getAllWeather();
    }

    public long getCountWeatherStore() {
        return weatherDao.getCountWeatherStore();
    }

    public void addWeatherStore(WeatherStore weatherStore) {

        weatherDao.insertWeatherStore(weatherStore);
        loadWeatherStore();
    }

    public void removeWeatherStoreById(long id) {
        weatherDao.deleteWeatherStoreById(id);
        loadWeatherStore();
    }




}
