package com.example.firsttestproject.regestration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.firsttestproject.R;
import com.example.firsttestproject.databinding.ActivityDashbordBinding;
import com.example.firsttestproject.databinding.ActivityNewuserBinding;

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