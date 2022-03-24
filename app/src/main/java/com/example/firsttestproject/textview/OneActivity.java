package com.example.firsttestproject.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.firsttestproject.R;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Button b=findViewById(R.id.btnSend);

        b.setOnClickListener(view -> {
            Emp ee =new Emp(1,"Bhagvat","Android",20000,"Gandhinagar");

            Intent i = new Intent(this,TwoActivity.class);
            i.putExtra("Object",ee);
            startActivity(i);
        });
    }


}