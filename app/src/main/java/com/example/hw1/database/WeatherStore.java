package com.example.hw1.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"city_name", "temperature", "date_time"})})
public class WeatherStore {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "date_time")
    public String dateTime;

    @ColumnInfo(name = "city_name")
    public String cityName;

    public String temperature;

    @ColumnInfo(name = "wind_speed")
    public Integer windSpeed;

    public Integer humidity;


}
