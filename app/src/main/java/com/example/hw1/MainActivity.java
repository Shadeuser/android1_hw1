package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
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

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Constants{



    //For dimensions MainFr
    LinearLayout linearCurWeather;
    LinearLayout linearDayButtons;
    Button btnChangeCity;
    TextView txtCityName;
    TextView txtExtraWeather;

    //For dimensions OneFr
    TextView txtCityChoose;
    EditText edtChangeCityName;
    Button btnConfirm;
    CheckBox chkExtraParams;
    FragmentTransaction fTrans;
    RecyclerView cityRecyclerView;

    NavigationView navigationView;


    final String MY_TAG ="MY_TAG";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        getScreenOrientation();
    }






    private String getScreenOrientation() {
        linearCurWeather = findViewById(R.id.linearCurWeather);
        btnChangeCity = findViewById(R.id.btnChangeCity);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return "Портретная ориентация";
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

//            linearCurWeather.setPadding(0, 0, 0, 0);
//            btnChangeCity.setVisibility(View.GONE);
//            btnConfirm.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onClickBtnConfirm();
//                }
//            });
            return "Альбомная ориентация";
        } else {
            return "";
        }

    }





    public void onClickBtnConfirm() {
//        edtChangeCityName = findViewById(R.id.edtChangeCityName);

        txtCityName = findViewById(R.id.txtCityName);
//        txtExtraWeather = findViewById(R.id.txtExtraWeather);

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
}
