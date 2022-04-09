package com.example.firsttestproject.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.firsttestproject.databinding.ActivityMyViewPagerBinding;
import com.google.android.material.tabs.TabLayout;

public class MyViewPagerActivity extends AppCompatActivity {
    private ActivityMyViewPagerBinding vbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        vbinding = ActivityMyViewPagerBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(vbinding.getRoot());

        vbinding.tabLayout.addTab(vbinding.tabLayout.newTab().setText("Chat"));
        vbinding.tabLayout.addTab(vbinding.tabLayout.newTab().setText("Status"));
        vbinding.tabLayout.addTab(vbinding.tabLayout.newTab().setText("Calls"));

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),getLifecycle());
        vbinding.viewPager.setAdapter(adapter);

        vbinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vbinding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vbinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                vbinding.tabLayout.selectTab(vbinding.tabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}