package com.example.hw1;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherRequest implements Parcelable{
    private Main main;
    private Wind wind;

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Wind getWind() {
        return wind;
    }

    protected WeatherRequest(Parcel in) {
        name = in.readString();
    }

    public static final Creator<WeatherRequest> CREATOR = new Creator<WeatherRequest>() {
        @Override
        public WeatherRequest createFromParcel(Parcel in) {
            return new WeatherRequest(in);
        }

        @Override
        public WeatherRequest[] newArray(int size) {
            return new WeatherRequest[size];
        }
    };

    public void setMain(Main main) {
        this.main = main;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

    public Main getMain() {
        return main;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}

