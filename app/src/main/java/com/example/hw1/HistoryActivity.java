package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private final String[] wl = {
            "10:00 +15", "11:00 +15", "12:00 +17", "13:00 +18", "14:00 +19",
            "15:00 +19", "16:00 +18", "17:00 +17", "18:00 +15", "19:00 +15",
            "20:00 +14", "21:00 +13", "22:00 +13", "23:00 +12", "00:00 +11"
        };

    WeatherAdapter adapter;
    TextView txtViewCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        adapter = new WeatherAdapter();
        RecyclerView recyclerView = findViewById(R.id.newRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        setList(Arrays.asList(wl));
    }

    public void setList(List<String> list) {
        adapter.setWeatherList(list);

    }
}
