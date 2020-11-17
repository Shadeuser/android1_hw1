package com.example.hw1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainFragment extends Fragment implements Constants, DialogResult {


    Button btnChangeCity;
    Button btnWeatherHistory;
    TextView txtTemperature;
    TextView txtWindSpeed;
    TextView txtHimidity;
    TextView txtCityName;
    DialogResult callBack;
    OpenWeather openWeather;
    ImageView imageViewCity;
    final String MOSCOW = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Coat_of_Arms_of_Moscow.svg/200px-Coat_of_Arms_of_Moscow.svg.png";
    final String CHELYABINSK = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/CoA_of_Chelyabinsk_%282000%29.svg/200px-CoA_of_Chelyabinsk_%282000%29.svg.png";
    final String SOCHI = "https://sochi.ru/local/templates/main_copy/user-img/gerb_1.jpg";
    final String UFA = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Coat_of_arms_of_Ufa.svg/1200px-Coat_of_arms_of_Ufa.svg.png";
    final String EKATERINBURG = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Coat_of_Arms_of_Yekaterinburg_%28Sverdlovsk_oblast%29.svg/200px-Coat_of_Arms_of_Yekaterinburg_%28Sverdlovsk_oblast%29.svg.png";
    final String NOVOSIBIRSK = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Coat_of_Arms_of_Novosibirsk.svg/200px-Coat_of_Arms_of_Novosibirsk.svg.png";
    final String SANKT_PETERSBURG = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Coat_of_Arms_of_Saint_Petersburg_%282003%29.svg/200px-Coat_of_Arms_of_Saint_Petersburg_%282003%29.svg.png";

    ConstraintLayout mainConstraintLayout;


    final String API_KEY = "0df31282d60ddb7c0c246690e01e8a84";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainConstraintLayout = view.findViewById(R.id.mainConstraintLayout);
        getScreenOrientation(view);

        initRetrofit();
        imageViewCity = view.findViewById(R.id.imageViewCity);
        Picasso.get()
                .load(NOVOSIBIRSK)
                .into(imageViewCity);

        btnChangeCity = view.findViewById(R.id.btnChangeCity);
        txtTemperature = view.findViewById(R.id.txtTemperature);
        txtTemperature = view.findViewById(R.id.txtTemperature);
        txtWindSpeed = view.findViewById(R.id.txtWindSpeed);
        txtHimidity = view.findViewById(R.id.txtHumidity);
        txtCityName = view.findViewById(R.id.txtCityName);
        btnWeatherHistory = view.findViewById(R.id.btnWeatherHistory);

        btnWeatherHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });
        btnChangeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack = MainFragment.this;
                MyBottomSheetDialogFragment dialogFragment = new MyBottomSheetDialogFragment(callBack);

                dialogFragment.show(getFragmentManager(), "dialog_fragment");
//                BottomSheetDialog dialog =(BottomSheetDialog) dialogFragment.getDialog();
//                LinearLayout linearLayout = dialog.findViewById(R.layout.fragment_my_bottom_sheet_dialog);
//                dialog.findViewById(android.support.design.R.id.design_bottom_sheet);




//                BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
//                FrameLayout bottomSheet = (FrameLayout)
//                        dialog.findViewById(android.support.design.R.id.design_bottom_sheet);
//                BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
//                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                behavior.setPeekHeight(0); // Remove this line to hide a dark background if you m
            }
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

    }

    @Override
    public void callBackResult(String city, boolean isExtra) {


        if (isExtra) {
            txtWindSpeed.setVisibility(View.VISIBLE);
            txtHimidity.setVisibility(View.VISIBLE);
        } else {
            txtWindSpeed.setVisibility(View.INVISIBLE);
            txtHimidity.setVisibility(View.INVISIBLE);
        }
        txtCityName.setText(city);
        String enCityName = "";
        String thisCity = "";

        if (getString(R.string.moscow_city) == city) {
            enCityName = getString(R.string.moscow_city_en);
            thisCity = MOSCOW;
        }


        if (getString(R.string.sochi_city) == city) {
            enCityName = getString(R.string.sochi_city_en);
            thisCity = SOCHI;
        }


        if (getString(R.string.novosibirsk_city) == city) {
            enCityName = getString(R.string.novosibirsk_city_en);
            thisCity = NOVOSIBIRSK;
        }

        if (getString(R.string.saint_petersburg_city) == city) {
            enCityName = getString(R.string.saint_petersburg_city_en);
            thisCity = SANKT_PETERSBURG;
        }


        if (getString(R.string.ekaterinburg_city) == city) {
            enCityName = getString(R.string.ekaterinburg_city_en);
            thisCity = EKATERINBURG;
        }


        if (getString(R.string.chelyabinsk_city) == city) {
            enCityName = getString(R.string.chelyabinsk_city_en);
            thisCity = CHELYABINSK;
        }


        if (getString(R.string.ufa_city) == city) {
            enCityName = getString(R.string.ufa_city_en);
            thisCity = UFA;
        }


//        GettingWeather gettingWeather = new GettingWeather(enCityName, getContext(), txtTemperature, txtWindSpeed, txtHimidity);
//        gettingWeather.getWeather();
        requestRetrofit(enCityName, API_KEY);
        Picasso.get()
                .load(thisCity)
                .into(imageViewCity);
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        openWeather = retrofit.create(OpenWeather.class);

    }

    private void requestRetrofit(String city, String apiKey) {
        openWeather.loadWeather(city, apiKey)
                .enqueue(new Callback<WeatherRequest>() {
                    @Override
                    public void onResponse(Call<WeatherRequest> call, Response<WeatherRequest> response) {
                        if (response.body() != null) {

                            final String temp = getString(R.string.txt_temperature) + response.body().getMain().getTemp();
                            final String wind = getString(R.string.txt_windspeed) + response.body().getWind().getSpeed();
                            final String humidity = getString(R.string.txt_himidity) + response.body().getMain().getHumidity();
                            txtTemperature.setText(temp);
                            txtWindSpeed.setText(wind);
                            txtHimidity.setText(humidity);
                        }

                    }

                    @Override
                    public void onFailure(Call<WeatherRequest> call, Throwable t) {
                        System.out.println(t.toString());
                    }
                });

    }

    private String getScreenOrientation(View view) {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return "Портретная ориентация";
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(mainConstraintLayout);
            constraintSet.connect(R.id.txtHumidity, ConstraintSet.END, view.getId(), ConstraintSet.END, 0);
            constraintSet.connect(R.id.txtTemperature, ConstraintSet.END, view.getId(), ConstraintSet.END, 0);
            constraintSet.connect(R.id.txtWindSpeed, ConstraintSet.END, view.getId(), ConstraintSet.END, 0);
            constraintSet.connect(R.id.txtCityName, ConstraintSet.END, view.getId(), ConstraintSet.END, 0);
            constraintSet.connect(R.id.textViewHead, ConstraintSet.END, view.getId(), ConstraintSet.END, 0);
            constraintSet.connect(R.id.imageViewCity, ConstraintSet.TOP, view.getId(), ConstraintSet.TOP, 0);
            constraintSet.applyTo(mainConstraintLayout);


            return "Альбомная ориентация";
        } else {
            return "";
        }
    }
}
