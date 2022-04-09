package com.example.firsttestproject.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.firsttestproject.viewpager.fragments.OneFragment;
import com.example.firsttestproject.viewpager.fragments.ThreeFragment;
import com.example.firsttestproject.viewpager.fragments.TwoFragment;

public class MyPagerAdapter extends FragmentStateAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OneFragment();
            case 1:
                return new TwoFragment();
            case 2:
                return new ThreeFragment();
        }
        return new  OneFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
