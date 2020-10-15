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


    TextView txtExraWeather;
    TextView txtTemperature;
    TextView txtCityName;



    //For dimensions
    LinearLayout linearCurWeather;
    LinearLayout linearDayButtons;
    TextView txtAboutWeather;


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
        Bundle bundle = getArguments();
        if (bundle != null) {
            txtCityName = view.findViewById(R.id.txtCityName);
            txtExraWeather = view.findViewById(R.id.txtExtraWeather);

            txtTemperature = view.findViewById(R.id.txtTemperature);
            savedInstanceState = getArguments();
            if (savedInstanceState != null) {
                txtCityName = view.findViewById(R.id.txtCityName);
                txtCityName.setText(savedInstanceState.getString(CITY_BUNDLE));
                txtExraWeather = view.findViewById(R.id.txtExtraWeather);
                if (bundle.getBoolean(ADD_OPTIONS_BUNDLE) == true) {
                    txtExraWeather.setVisibility(View.VISIBLE);
                } else {
                    txtExraWeather.setVisibility(View.INVISIBLE);
                }
            }


        }


        btnChangeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new OneFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.frPlace, fragment);
                ft.commit();
            }
        });





    }
}
