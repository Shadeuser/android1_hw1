package com.example.hw1;

import android.content.Context;
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

    //    Button btnToday;
    Button btnChangeCity;
    Button getNewButton;
    //    String todayTemperature;
//    TextView txtCityName;
    TextView txtExraWeather;
    //    Button btnAfterTomorrow;
    TextView txtTemperature;


    EditText edtChangeCityName;
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
//        Log.d(MY_TAG, getScreenOrientation(view));

//        linearCurWeather = view.findViewById(R.id.linearCurWeather);
//        txtAboutWeather = view.findViewById(R.id.txtAboutWeather);

//        linearCurWeather.setPadding(0, 10, 0, 0);


        btnChangeCity = view.findViewById(R.id.btnChangeCity);
        txtTemperature = view.findViewById(R.id.txtTemperature);
        Bundle bundle = getArguments();
        if (bundle != null) {
            txtCityName = view.findViewById(R.id.txtCityName);
            txtCityName.setText(bundle.getString(CITY_BUNDLE));
            txtExraWeather = view.findViewById(R.id.txtExtraWeather);

            if (bundle.getBoolean(ADD_OPTIONS_BUNDLE) == true) {
                txtExraWeather.setVisibility(View.VISIBLE);
            } else {
                txtExraWeather.setVisibility(View.INVISIBLE);
            }
        }


        btnChangeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                txtTemperature.setText("!!!!!!!!!!!!!!!!!!!!");
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
    public void onResume() {
        super.onResume();
    }





//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        // Checks the orientation of the screen
//
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Log.d(MY_TAG, "landscape");
//            linearCurWeather = getActivity().findViewById(R.id.linearCurWeather);
//            txtAboutWeather = getActivity().findViewById(R.id.txtAboutWeather);
//            linearCurWeather.setPadding(0,10, 0, 0);
//            txtAboutWeather.setPadding(0, 10, 0, 0);
//
//
//
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//
//            Log.d(MY_TAG, "portrait");
//        }
//    }

    //    public int getScreenOrientation() {
//
//
//        Display getOrient = getWindowManager().getDefaultDisplay();
//        int orientation = Configuration.ORIENTATION_UNDEFINED;
//        if(getOrient.getWidth()==getOrient.getHeight()){
//            orientation = Configuration.ORIENTATION_SQUARE;
//        } else{
//            if(getOrient.getWidth() < getOrient.getHeight()){
//                orientation = Configuration.ORIENTATION_PORTRAIT;
//            }else {
//                orientation = Configuration.ORIENTATION_LANDSCAPE;
//            }
//        }
//        return orientation;
//    }
}
