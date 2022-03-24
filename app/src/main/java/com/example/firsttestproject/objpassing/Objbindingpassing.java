package com.example.firsttestproject.objpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import  com.example.firsttestproject.databinding.ActivityObjbindingpassingBinding;
import com.example.firsttestproject.R;

public class Objbindingpassing extends AppCompatActivity {
private ActivityObjbindingpassingBinding actbinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actbinding=ActivityObjbindingpassingBinding.inflate(getLayoutInflater());
        setContentView(actbinding.getRoot());

        actbinding.senddata1.setOnClickListener(view -> {
            Emp e = new Emp(1,"Bhagvat","Android",20000,"Gandhinagar");

            actbinding.setPassobject(e);
        });
    }

}