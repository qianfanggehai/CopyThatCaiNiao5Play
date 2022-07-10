package com.example.copythatcainiao5play.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.copythatcainiao5play.R;
import com.example.copythatcainiao5play.common.Constant;
import com.example.copythatcainiao5play.common.util.ACache;
import com.example.copythatcainiao5play.ui.adapter.GuideFragmentAdapter;
import com.example.copythatcainiao5play.ui.decoration.DepthPageTransformer;
import com.example.copythatcainiao5play.ui.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.btn_enter)
    Button btnEnter;
    @BindView(R.id.indicator)
    LinearLayout indicator;


    @BindView(R.id.img_icon_1)
    ImageView imgIcon1;
    @BindView(R.id.img_icon_2)
    ImageView imgIcon2;
    @BindView(R.id.img_icon_3)
    ImageView imgIcon3;

    private GuideFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        initData();

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACache.get(getApplicationContext()).put(Constant.IS_SHOW_GUIDE,"0");
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                GuideActivity.this.finish();
            }
        });
    }

    private void initData() {


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GuideFragment.newInstance(R.drawable.consumer, R.color.color_bg_guide1, R.string.guide1));
        fragments.add(GuideFragment.newInstance(R.drawable.sjpp, R.color.color_bg_guide2, R.string.guide2));
        fragments.add(GuideFragment.newInstance(R.drawable.tagg, R.color.color_bg_guide3, R.string.guide3));

        adapter = new GuideFragmentAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);

        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(this);

        viewPager.setPageTransformer(true,new DepthPageTransformer());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        if (position==0){
            imgIcon1.setImageResource(R.color.color_white);
            imgIcon2.setImageResource(R.color.colorAccent);
            imgIcon3.setImageResource(R.color.colorAccent);
        }else if (position==1){
            imgIcon1.setImageResource(R.color.colorAccent);
            imgIcon2.setImageResource(R.color.color_white);
            imgIcon3.setImageResource(R.color.colorAccent);
        }else if (position==2){
            imgIcon1.setImageResource(R.color.colorAccent);
            imgIcon2.setImageResource(R.color.colorAccent);
            imgIcon3.setImageResource(R.color.color_white);
        }

        btnEnter.setVisibility((position==adapter.getCount()-1)? View.VISIBLE:View.GONE);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}