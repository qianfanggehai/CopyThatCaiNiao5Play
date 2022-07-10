package com.example.copythatcainiao5play.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.copythatcainiao5play.bean.FragmentInfo;
import com.example.copythatcainiao5play.ui.fragment.CategoryFragment;
import com.example.copythatcainiao5play.ui.fragment.GamesFragment;
import com.example.copythatcainiao5play.ui.fragment.RankingFragment;
import com.example.copythatcainiao5play.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> mFragments=new ArrayList<>(4);

    private void initFragments(){


        mFragments.add(new FragmentInfo("推荐",RecommendFragment.class));
        mFragments.add(new FragmentInfo("排行",RankingFragment.class));
        mFragments.add(new FragmentInfo("游戏",GamesFragment.class));
        mFragments.add(new FragmentInfo("种类",CategoryFragment.class));
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        initFragments();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        try {
            return (Fragment) mFragments.get(position).getFragment().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
//        Fragment fragment=null;
//        switch (position){
//            case 0:
//                fragment=new RecommendFragment();
//                break;
//            case 1:
//                fragment=new RankingFragment();
//                break;
//            case 2:
//                fragment=new GamesFragment();
//                break;
//            case 3:
//                fragment=new CategoryFragment();
//                break;
//        }
//        return mFragments.get(0);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
