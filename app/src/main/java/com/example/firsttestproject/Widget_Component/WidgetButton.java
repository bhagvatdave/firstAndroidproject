package com.example.firsttestproject.Widget_Component;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.firsttestproject.databinding.ActivityWidgetButtonBinding;

public class WidgetButton extends AppCompatActivity {
private ActivityWidgetButtonBinding wbbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wbbinding=ActivityWidgetButtonBinding.inflate(getLayoutInflater());
        setContentView(wbbinding.getRoot());

wbbinding.btnSTC.setOnClickListener(view -> {
    Intent i = new Intent(this,STCactivity.class);
    startActivity(i);
});
        wbbinding.btnseek.setOnClickListener(view -> {
            Intent i = new Intent(this,Seekbar.class);
            startActivity(i);
        });

        wbbinding.btnradio.setOnClickListener(view -> {
            Intent i = new Intent(this,STCactivity.class);
            startActivity(i);
        });
    }
}