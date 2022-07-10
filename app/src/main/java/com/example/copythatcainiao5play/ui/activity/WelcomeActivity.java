package com.example.copythatcainiao5play.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.eftimoff.androipathview.PathView;
import com.example.copythatcainiao5play.R;
import com.example.copythatcainiao5play.common.Constant;
import com.example.copythatcainiao5play.common.util.ACache;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.pathView)
    PathView pathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        pathView.getPathAnimator()
                .delay(10)
                .duration(3000)
                .listenerEnd(this::jump)
                .start();
    }

    private void jump() {
        String isShowGuide = ACache.get(this).getAsString(Constant.IS_SHOW_GUIDE);
        if (isShowGuide==null){
            startActivity(new Intent(this,GuideActivity.class));
        }else {
            startActivity(new Intent(this,MainActivity.class));
        }
        this.finish();
    }
}