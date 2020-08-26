package com.example.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.Map;

public class CityActivity extends AppCompatActivity implements Constants{

    Parcel parcel;
    Button confirmButton;
    TextView txtChangeCityName;
    CheckBox chkExtraParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_activity);
        confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener((v) ->  {
            confirmButtonOnClick();
        });

    }

    private void confirmButtonOnClick() {
        txtChangeCityName = findViewById(R.id.txtChangeCityName);
        String city = txtChangeCityName.getText().toString();

        chkExtraParams = findViewById(R.id.chkExtraParams);
        boolean extras = chkExtraParams.isChecked();

        WeatherParams weatherParams = new WeatherParams(txtChangeCityName.getText().toString(), extras);

        Intent intent = new Intent(CityActivity.this, MainActivity.class);
        intent.putExtra(INTENT_TEXT, weatherParams);
        setResult(RESULT_OK, intent);
        finish();
    }


}
