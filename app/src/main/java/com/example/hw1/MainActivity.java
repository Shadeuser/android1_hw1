package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.example.hw1.broadcast.AirReceiver;
import com.example.hw1.broadcast.BatteryReceiver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity implements Constants{



    //For dimensions MainFr
    TextView txtCityName;
    TextView txtExtraWeather;

    //For dimensions OneFr

    EditText edtChangeCityName;
    CheckBox chkExtraParams;
    FragmentTransaction fTrans;
    NavigationView navigationView;
    final String MY_TAG ="MY_TAG";
    AirReceiver airReceiver;
    BatteryReceiver batteryReceiver;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        airReceiver = new AirReceiver();
        registerReceiver(airReceiver, new
                IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));

        batteryReceiver = new BatteryReceiver();
        registerReceiver(batteryReceiver, new
                IntentFilter(Intent.ACTION_BATTERY_LOW));

        initGetToken();
        initNotificationChannel();

        navigationView = findViewById(R.id.nav_View);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(getApplicationContext(), "Меню находитсч в разработке!", Toast.LENGTH_SHORT).show();
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.setScrimColor(Color.TRANSPARENT);
                Intent intent = new Intent(getApplicationContext(), CreatorActivity.class);
                startActivity(intent);

                return true;
            }
        });
    }



    private void initGetToken() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("PushMessage", "getInstanceId failed", task.getException());
                            return;
                        }
                    }
                });
    }

    private void initNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel("2", "name", importance);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void onClickBtnConfirm() {
        txtCityName = findViewById(R.id.txtCityName);
        txtCityName.setText(edtChangeCityName.getText());
        int vis = chkExtraParams.isChecked() ? View.VISIBLE : View.GONE;
        txtExtraWeather.setVisibility(vis);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        final SearchView searchText = (SearchView) search.getActionView();
        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"Поиск временно не работает!", Toast.LENGTH_LONG).show();
                 return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(airReceiver);
        unregisterReceiver(batteryReceiver);
    }
}
