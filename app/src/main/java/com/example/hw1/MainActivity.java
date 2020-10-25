package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Constants {



    //For dimensions MainFr
    LinearLayout linearCurWeather;
    LinearLayout linearDayButtons;
    TextView txtAboutWeather;
    Button btnChangeCity;
    TextView txtCityName;
    TextView txtExtraWeather;

    //For dimensions OneFr
    TextView txtCityChoose;
    EditText edtChangeCityName;
    Button btnConfirm;
    CheckBox chkExtraParams;
    Fragment fragMain;
    FragmentTransaction fTrans;
    RecyclerView cityRecyclerView;


    final String MY_TAG ="MY_TAG";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d(MY_TAG, getScreenOrientation());
        getScreenOrientation();



    }



    private String getScreenOrientation() {
        linearCurWeather = findViewById(R.id.linearCurWeather);

        linearDayButtons = findViewById(R.id.linearDayButtons);
        btnChangeCity = findViewById(R.id.btnChangeCity);
        txtCityChoose = findViewById(R.id.txtCityChoose);
//        edtChangeCityName = findViewById(R.id.edtChangeCityName);
        cityRecyclerView = findViewById(R.id.cityRecyclerView);






        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return "Портретная ориентация";
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            linearCurWeather.setPadding(0, 0, 0, 0);
//            txtAboutWeather.setPadding(0,0,0,0);
            linearDayButtons.setPadding(0, 0, 0, 0);
            btnChangeCity.setVisibility(View.GONE);
            txtCityChoose.setPadding(0, 0, 0, 0);
//            edtChangeCityName.setPadding(0, 50, 0, 0);

            btnConfirm = findViewById(R.id.confirmButton);
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickBtnConfirm();
                }
            });
            return "Альбомная ориентация";
        } else {
            return "";
        }

    }





    public void onClickBtnConfirm() {
//        edtChangeCityName = findViewById(R.id.edtChangeCityName);
        chkExtraParams = findViewById(R.id.chkExtraParams);
        txtCityName = findViewById(R.id.txtCityName);
//        txtExtraWeather = findViewById(R.id.txtExtraWeather);

        txtCityName.setText(edtChangeCityName.getText());
        int vis = chkExtraParams.isChecked() ? View.VISIBLE : View.GONE;
        txtExtraWeather.setVisibility(vis);
    }








}
