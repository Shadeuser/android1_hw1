package com.example.hw1;

import java.text.DecimalFormat;

public class Main {
    private Float temp;
    private String pressure;
    private String humidity;
    private String temp_min;
    private String temp_max;

    DecimalFormat decimalFormat= new DecimalFormat("#.#");

    public void setTemp(Float temp) {
        this.temp = temp;


    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getTemp() {
        return decimalFormat.format(temp -273.15);
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }
}
