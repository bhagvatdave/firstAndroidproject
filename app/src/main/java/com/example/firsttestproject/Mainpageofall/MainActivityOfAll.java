package com.example.firsttestproject.Mainpageofall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.firsttestproject.R;
import com.example.firsttestproject.Widget_Component.STCactivity;
import com.example.firsttestproject.Widget_Component.Seekbar;
import com.example.firsttestproject.databinding.ActivityMainOfAllBinding;
import com.example.firsttestproject.objpassing.Objbindingpassing;
import com.example.firsttestproject.regestration.LoginPage;
import com.example.firsttestproject.textview.OneActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivityOfAll extends AppCompatActivity {
 private ActivityMainOfAllBinding Allbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Allbinding= ActivityMainOfAllBinding.inflate(getLayoutInflater());
        setContentView(Allbinding.getRoot());
        getSupportActionBar().hide();

        Allbinding.toolbar.setNavigationOnClickListener(view -> {
            Allbinding.drawerLayout.openDrawer(Gravity.LEFT);
        });

       Allbinding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Intent i;
               switch (item.getItemId()) {
                   case R.id.Objbindingpassing:
                       i = new Intent(MainActivityOfAll.this, Objbindingpassing.class);
                       startActivity(i);
                       break;
                   case R.id.LoginPage:
                       i = new Intent(MainActivityOfAll.this, LoginPage.class);
                       startActivity(i);
                       break;
                   case R.id.OneActivity:
                       i = new Intent(MainActivityOfAll.this, OneActivity.class);
                       startActivity(i);
                       break;
                   case R.id.STCactivity:
                       i = new Intent(MainActivityOfAll.this, STCactivity.class);
                       startActivity(i);
                       break;
                   case R.id.Seekbar:
                       i = new Intent(MainActivityOfAll.this, Seekbar.class);
                       startActivity(i);
                       break;
               }

               return false;
           }


       });
    }
}