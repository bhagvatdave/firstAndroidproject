package com.example.firsttestproject.Widget_Component;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import com.example.firsttestproject.databinding.ActivitySeekbarBinding;

public class Seekbar extends AppCompatActivity  implements SeekBar.OnSeekBarChangeListener {
    private ActivitySeekbarBinding sbbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sbbinding = ActivitySeekbarBinding.inflate(getLayoutInflater());
        setContentView(sbbinding.getRoot());

        sbbinding.ivColorCode.setBackgroundColor(Color.BLACK);

        sbbinding.sbBlue.setOnSeekBarChangeListener(this);
        sbbinding.sbGreen.setOnSeekBarChangeListener(this);
        sbbinding.sbRed.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int red = sbbinding.sbRed.getProgress();
        int blue = sbbinding.sbBlue.getProgress();
        int green = sbbinding.sbGreen.getProgress();

        sbbinding.ivColorCode.setBackgroundColor(Color.rgb(red,green,blue));

        sbbinding.textView2.setText(String.format("#%02x%02x%02x", red, green,blue));

        sbbinding.textView3.setText(red+" "+green+" "+blue);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}