package com.example.hw1;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainFragment extends Fragment implements Constants {


    Button btnChangeCity;
    Button btnWeatherHistory;
    TextView txtTemperature;
    TextView txtWindSpeed;
    TextView txtHimidity;
    TextView txtCityName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChangeCity = view.findViewById(R.id.btnChangeCity);
        txtTemperature = view.findViewById(R.id.txtTemperature);
        savedInstanceState = getArguments();
        if (savedInstanceState != null) {

//            savedInstanceState = getArguments();
            txtTemperature = view.findViewById(R.id.txtTemperature);
            txtWindSpeed = view.findViewById(R.id.txtWindSpeed);
            txtHimidity = view.findViewById(R.id.txtHumidity);
            txtCityName = view.findViewById(R.id.txtCityName);
            String currentCityName = savedInstanceState.getString(CITY_BUNDLE);
            Boolean isExtraParams = savedInstanceState.getBoolean(ADD_OPTIONS_BUNDLE);
            if (isExtraParams) {
                txtWindSpeed.setVisibility(View.VISIBLE);
                txtHimidity.setVisibility(View.VISIBLE);
            } else {
                txtWindSpeed.setVisibility(View.INVISIBLE);
                txtHimidity.setVisibility(View.INVISIBLE);
            }
            txtCityName.setText(currentCityName);
            String enCityName = "";

            if (getString(R.string.moscow_city) == currentCityName) {
                enCityName = getString(R.string.moscow_city_en);
            }


            if (getString(R.string.sochi_city) == currentCityName) {
                enCityName = getString(R.string.sochi_city_en);
            }


            if (getString(R.string.novosibirsk_city) == currentCityName) {
                enCityName = getString(R.string.novosibirsk_city_en);
            }

            if (getString(R.string.saint_petersburg_city) == currentCityName) {
                enCityName = getString(R.string.saint_petersburg_city_en);
            }


            if (getString(R.string.ekaterinburg_city) == currentCityName) {
                enCityName = getString(R.string.ekaterinburg_city_en);
            }


            if (getString(R.string.chelyabinsk_city) == currentCityName) {
                enCityName = getString(R.string.ekaterinburg_city_en);
            }


            if (getString(R.string.ufa_city) == currentCityName) {
                enCityName = getString(R.string.ufa_city_en);
            }

            GettingWeather gettingWeather = new GettingWeather(enCityName, getContext(), txtTemperature, txtWindSpeed, txtHimidity);
            gettingWeather.getWeather();

        }

        btnWeatherHistory = view.findViewById(R.id.btnWeatherHistory);
        btnWeatherHistory.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(getContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });
        btnChangeCity.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                Fragment fragment = null;
                fragment = new OneFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.frPlace, fragment);
                ft.commit();
            }
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

    }
}
