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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class OneFragment extends Fragment implements Constants {
    Button btnConfirm;
    Fragment fragMain;
    FragmentTransaction fTrans;
    CheckBox chkExtraParams;

    CityAdapter adapter;
    RecyclerView cityRecyclerView;
    TextView txtViewCity;
    TextView txtTown;
    ArrayList myList;
    Button btnAddCity;
    EditText edtAddCity;



    private final String[] cities = {
        "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург",
        "Рязань", "Челябинск", "Уфа"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        myList = new ArrayList<String>();
//        myList = (ArrayList<String>)Arrays.asList(cities);
        Collections.addAll(myList, cities);


        super.onViewCreated(view, savedInstanceState);
        txtViewCity = view.findViewById(R.id.txtViewCity);
        adapter = new CityAdapter();
        cityRecyclerView = view.findViewById(R.id.cityRecyclerView);
        cityRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        cityRecyclerView.setAdapter(adapter);
        adapter.setList(myList);
        adapter.setOnCityClickListener(new OnCityClickListener() {
            @Override
            public void onClicked(String city) {
                txtTown = view.findViewById(R.id.txtTown);
                txtTown.setText(city);
            }
        });

        edtAddCity = view.findViewById(R.id.edtAddCity);
        btnAddCity = view.findViewById(R.id.btnAddCity);
        btnAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCityToList(edtAddCity.getText().toString());

            }
        });







        txtTown = view.findViewById(R.id.txtTown);
        btnConfirm = view.findViewById(R.id.confirmButton);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    chkExtraParams = view.findViewById(R.id.chkExtraParams);
                    fragMain = new MainFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(CITY_BUNDLE, txtTown.getText().toString());
                    bundle.putBoolean(ADD_OPTIONS_BUNDLE, chkExtraParams.isChecked());
                    fragMain.setArguments(bundle);
                    fTrans = getFragmentManager().beginTransaction();
                    fTrans.replace(R.id.frPlace, fragMain);
                    fTrans.commit();
                }
            });

        }

    }

    public void addCityToList(String curCity) {
        myList.add(curCity);
        adapter.setList(myList);
    }



}
