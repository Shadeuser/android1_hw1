package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hw1.database.App;
import com.example.hw1.database.RandomWeather;
import com.example.hw1.database.WeatherDao;
import com.example.hw1.database.WeatherRecyclerAdapter;
import com.example.hw1.database.WeatherSource;
import com.example.hw1.database.WeatherStore;

import java.util.Arrays;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {


//    private final String[] wl = {
//            "10:00 +15", "11:00 +15", "12:00 +17", "13:00 +18", "14:00 +19",
//            "15:00 +19", "16:00 +18", "17:00 +17", "18:00 +15", "19:00 +15",
//            "20:00 +14", "21:00 +13", "22:00 +13", "23:00 +12", "00:00 +11"
//        };
//
//    WeatherAdapter adapter;
    private WeatherSource weatherSource;
    WeatherRecyclerAdapter weatherRecyclerAdapter;
    TextView txtViewCity;
    Button btnRecDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initRecyclerView();
//
//        adapter = new WeatherAdapter();
//        RecyclerView recyclerView = findViewById(R.id.newRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
//        recyclerView.setAdapter(adapter);
//        setList(Arrays.asList(wl));

//        btnRecDatabase = findViewById(R.id.btnRecDatabase);
//        btnRecDatabase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                WeatherStore insertWeatherStore = new RandomWeather(getResources())
//                        .setRndWeatherStore();
//                weatherSource.removeWeatherStoreById();
//                weatherSource.addWeatherStore(insertWeatherStore);
//                weatherRecyclerAdapter.notifyDataSetChanged();
//
//            }
//        });

    }

//    public void setList(List<String> list) {
//        adapter.setWeatherList(list);
//
//    }
    public void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.newRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        WeatherDao weatherDao = App
                .getInstance()
                .getWeatherDao();
        weatherSource = new WeatherSource(weatherDao);
        weatherSource.loadWeatherStore();
        weatherRecyclerAdapter = new WeatherRecyclerAdapter(weatherSource, this);
        recyclerView.setAdapter(weatherRecyclerAdapter);
    }
}
