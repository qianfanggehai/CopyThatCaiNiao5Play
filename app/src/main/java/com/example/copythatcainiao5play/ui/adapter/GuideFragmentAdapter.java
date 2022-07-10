package com.example.copythatcainiao5play.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragments;

    public void setFragments(List<Fragment> fragments){

        if (fragments==null){
            mFragments=new ArrayList<>();
        }else {
            mFragments=fragments;
        }
    }

    public GuideFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
