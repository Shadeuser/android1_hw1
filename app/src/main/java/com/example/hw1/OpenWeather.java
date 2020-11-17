package com.example.hw1;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface OpenWeather {

    @GET("data/2.5/weather")
    Call<WeatherRequest>  loadWeather(@Query("q") String cityCountry, @Query("appid") String keyApi);


}
