package com.example.hw1;

import java.io.Serializable;

public class WeatherParams implements Serializable {
    private String city;
    private boolean extras;

    public String getCity() {
        return city;
    }

    public boolean getExtras() {
        return extras;
    }

    public WeatherParams(String city, boolean extras) {
        this.city = city;
        this.extras = extras;
    }
}
