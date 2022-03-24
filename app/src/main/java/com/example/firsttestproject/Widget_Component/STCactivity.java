package com.example.firsttestproject.Widget_Component;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.example.firsttestproject.databinding.ActivityStcactivityBinding;

import java.util.Random;
import java.util.stream.IntStream;

public class STCactivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
private ActivityStcactivityBinding stcbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stcbinding = ActivityStcactivityBinding.inflate(getLayoutInflater());
        setContentView(stcbinding.getRoot());

        stcbinding.checkBox.setOnCheckedChangeListener(this);
        stcbinding.switch1.setOnCheckedChangeListener(this);
        stcbinding.toggleButton.setOnCheckedChangeListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b){
           stcbinding.checkBox.setChecked(true);
            stcbinding.switch1.setChecked(true);
            stcbinding.toggleButton.setChecked(true);
            stcbinding.getRoot().setBackgroundColor(Color.rgb(randomno(),randomno(),randomno()));
        }else{
            stcbinding.checkBox.setChecked(false);
            stcbinding.switch1.setChecked(false);
            stcbinding.toggleButton.setChecked(false);
            stcbinding.getRoot().setBackgroundColor(Color.CYAN);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    int randomno() {
        Random rand = new Random();
        try (IntStream ints = rand.ints(0, 255)) {
        }
        return rand.nextInt();
    }
}