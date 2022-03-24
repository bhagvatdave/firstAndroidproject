package com.example.firsttestproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn =findViewById(R.id.btntst);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast tst = Toast.makeText(View,"This is tost",Toast.LENGTH_SHORT);

            }
        });
    }

}