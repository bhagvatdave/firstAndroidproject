package com.example.firsttestproject.Firebase_login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firsttestproject.databinding.ActivityDashbordBinding;
import com.example.firsttestproject.Firebase_login.Userdata;

public class Dashbord extends AppCompatActivity {
    private ActivityDashbordBinding Dashbordbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dashbordbinding=ActivityDashbordBinding.inflate(getLayoutInflater());
        setContentView(Dashbordbinding.getRoot());

        Intent i =getIntent();
        Userdata UD2 = (Userdata) i.getSerializableExtra("Object1");
        Dashbordbinding.Title1.setText("Welcome " + UD2.username);
    }
}