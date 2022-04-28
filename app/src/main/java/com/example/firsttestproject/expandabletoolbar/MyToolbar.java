package com.example.firsttestproject.expandabletoolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;

import com.example.firsttestproject.databinding.ActivityMyToolbarBinding;
import com.google.android.material.appbar.AppBarLayout;

public class MyToolbar extends AppCompatActivity {
private ActivityMyToolbarBinding tbinding;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tbinding=ActivityMyToolbarBinding.inflate(getLayoutInflater());
        setContentView(tbinding.getRoot());
        getSupportActionBar().hide();
        tbinding.webview.setWebViewClient(new WebViewClient());

        tbinding.webview.loadUrl("https://www.bing.com/");
    tbinding.webview.setOnScrollChangeListener((view, i, i1, i2, i3) -> {
        AppBarLayout appBarLayout=tbinding.appbar;
        appBarLayout.setExpanded(i1<i3,true);
    });
    }
}