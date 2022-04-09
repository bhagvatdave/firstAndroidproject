package com.example.firsttestproject.Navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firsttestproject.R;
import com.example.firsttestproject.databinding.ActivityDrawerBinding;

public class Drawer extends AppCompatActivity {

    private ActivityDrawerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.toolbar.setNavigationOnClickListener(view -> {

            binding.drawerLayout.openDrawer(Gravity.LEFT);

        });

        binding.toolbar.setOnMenuItemClickListener(item -> {

            // TODO : menu click

            return false;
        });


        binding.navigationView.setNavigationItemSelectedListener(item -> {

            // TODO : navigation menu click

            return false;
        });

        View view = binding.navigationView.getHeaderView(0);

        ImageView iv = view.findViewById(R.id.ivProfile);
        TextView tv1 = view.findViewById(R.id.tvName);
        TextView tv2 = view.findViewById(R.id.tvEmail);

        // TODO : Do click event



    }
}