package com.example.hw1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

public class MyBottomSheetDialogFragment extends BottomSheetDialogFragment implements Constants {
    Spinner myCitySpinner;
    MaterialButton btnCityConfirm;
    Fragment frMain;
    private DialogResult callBack;

    public MyBottomSheetDialogFragment (DialogResult callBack) {
        this.callBack = callBack;
    }
//
//    public static MyBottomSheetDialogFragment newInstance(DialogResult callBack){
//
//
//        this.callBack = callBack;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_bottom_sheet_dialog, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        myCitySpinner = view.findViewById(R.id.myCitySpinner);
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myCitySpinner.setAdapter(adapter);
        btnCityConfirm = view.findViewById(R.id.btnConfirmCity);
        btnCityConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//       ;
//                Bundle bundle = new Bundle();
//                bundle.putString(CITY_BUNDLE, "Приветвы");
//                bundle.putBoolean(ADD_OPTIONS_BUNDLE, true);
//                frMain = new MainFragment();
//                frMain.setArguments(bundle);

                    callBack.callBackResult(myCitySpinner.getSelectedItem().toString(), true);

                dismiss();
            }
        });

        setCancelable(false);

    }

}