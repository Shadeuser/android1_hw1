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

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class OneFragment extends Fragment implements Constants {
    Button btnConfirm;
    Fragment fragMain;
    FragmentTransaction fTrans;
    EditText edtChangeCityName;
    CheckBox chkExtraParams;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnConfirm = view.findViewById(R.id.confirmButton);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edtChangeCityName =view.findViewById(R.id.edtChangeCityName);
                    chkExtraParams = view.findViewById(R.id.chkExtraParams);
                    fragMain = new MainFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(CITY_BUNDLE, edtChangeCityName.getText().toString());
                    bundle.putBoolean(ADD_OPTIONS_BUNDLE, chkExtraParams.isChecked());
                    fragMain.setArguments(bundle);
                    fTrans = getFragmentManager().beginTransaction();
                    fTrans.replace(R.id.frPlace, fragMain);
                    fTrans.commit();
                }
            });

        }

    }

}
