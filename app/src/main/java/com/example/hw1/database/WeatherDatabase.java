package com.example.hw1.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {WeatherStore.class}, version = 1)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDao getWeatherDao();


}
