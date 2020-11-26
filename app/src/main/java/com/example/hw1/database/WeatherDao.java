package com.example.hw1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import retrofit2.http.DELETE;

@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWeatherStore(WeatherStore weatherStore);

    @Delete
    void deleteWeatherStore(WeatherStore weatherStore);

    @Query("DELETE FROM weatherstore WHERE id = :id")
    void deleteWeatherStoreById(long id);

    @Query("SELECT * FROM weatherstore")
    List<WeatherStore> getAllWeather();

    @Query("SELECT * FROM weatherstore where id =:id")
    WeatherStore getWeatherById(long id);

    @Query("SELECT COUNT() FROM weatherstore")
    long getCountWeatherStore();
}
