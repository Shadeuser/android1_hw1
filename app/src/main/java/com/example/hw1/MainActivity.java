package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Constants {

    TextView txtTemperature;
    Button btnToday;
    Button btnChangeCity;
    String todayTemperature;
    TextView txtCityName;
    TextView txtExraWeather;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("myTAG", "onCreate");
        setContentView(R.layout.activity_main);

        btnToday = findViewById(R.id.btnToday);
        btnChangeCity = findViewById(R.id.btnChangeCity);
        txtTemperature = findViewById(R.id.txtTemperature);
        todayTemperature = txtTemperature.getText().toString();

        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todayTemperature = "+15";
                txtTemperature.setText(todayTemperature);
            }
        });

        btnChangeCity.setOnClickListener((v)-> {
            Intent intent = new Intent(MainActivity.this, CityActivity.class);
            startActivityForResult(intent, RESULT_INT);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myTAG", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myTAG", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myTAG", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("myTAG", "onSaveInstanceState");
        outState.putString(EXTRA_COUNTER, todayTemperature);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myTAG", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myTAG", "onResume");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("myTAG", "onRestoreInstanceState");
        final String savedTemperature = savedInstanceState.getString(EXTRA_COUNTER, "-");
        txtTemperature.setText(String.valueOf(savedTemperature));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        WeatherParams weatherParams = (WeatherParams) data.getExtras().getSerializable(INTENT_TEXT);
        if (resultCode == RESULT_OK) {
            txtCityName = findViewById(R.id.txtCityName);
            txtCityName.setText(weatherParams.getCity());

            txtExraWeather = findViewById(R.id.txtExtraWeather);
            if (weatherParams.getExtras()) {
                txtExraWeather.setVisibility(View.VISIBLE);
            } else {
                txtExraWeather.setVisibility(View.INVISIBLE);
            };


        }
    }
}
