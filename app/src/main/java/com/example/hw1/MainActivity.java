package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtTemperature;
    Button btnToday;

    String todayTemperature;

    private static final String EXTRA_COUNTER = "EXTRA_COUNTER_MAIN_ACTIVITY";

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d("myTAG", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_LONG).show();
        Log.d("myTAG", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
        Log.d("myTAG", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_LONG).show();
        Log.d("myTAG", "onSaveInstanceState");
        outState.putString(EXTRA_COUNTER, todayTemperature);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_LONG).show();
        Log.d("myTAG", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_LONG).show();
        Log.d("myTAG", "onResume");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_LONG).show();
        Log.d("myTAG", "onRestoreInstanceState");
        final String savedTemperature = savedInstanceState.getString(EXTRA_COUNTER, "-");
        txtTemperature.setText(String.valueOf(savedTemperature));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        Log.d("myTAG", "onCreate");
        setContentView(R.layout.activity_main);

        btnToday = findViewById(R.id.btnToday);
        txtTemperature = findViewById(R.id.txtTemperature);
        todayTemperature = txtTemperature.getText().toString();

        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todayTemperature = "+15";
                txtTemperature.setText(todayTemperature);
            }
        });
    }

}
