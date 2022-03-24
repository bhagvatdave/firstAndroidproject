package com.example.firsttestproject.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.firsttestproject.R;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TextView TV1 = findViewById(R.id.TVid);
        TextView TV2 = findViewById(R.id.TVname);
        TextView TV3 = findViewById(R.id.TVField);
        TextView TV4 = findViewById(R.id.TVselery);
        TextView TV5 = findViewById(R.id.TVaddress);

        Intent i =getIntent();
        Emp eee = (Emp) i.getSerializableExtra("Object");

        TV1.setText(eee.id);
        TV2.setText(eee.Name);
        TV3.setText(eee.Field);
        TV4.setText(eee.selery);
        TV5.setText(eee.Address);

    }
}