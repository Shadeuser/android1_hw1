package com.example.hw1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

class UrlData {
    Handler handler;

    public UrlData(Handler handler) {
        this.handler = handler;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getUrlData(URL url, Context context) {

        HttpsURLConnection urlConnection = null;
        try {
            urlConnection =(HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            return getLines(in);
        } catch (IOException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
//                                Toast.makeText(context, "Ошибка Загруза данных", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(context)
                            .setTitle("Внимание!")
                            .setMessage("Ошибка получения данных.")
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(R.drawable.ic_baseline_error_24)
                            .setCancelable(false)
                            .create()
                            .show();



                }
            });
            e.printStackTrace();
        }
        return null;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getLines(BufferedReader in) {
        return in.lines().collect(Collectors.joining("\n"));

    }


}
