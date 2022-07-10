package com.example.copythatcainiao5play.ui.activity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import com.example.copythatcainiao5play.AppApplication;
import com.example.copythatcainiao5play.di.component.AppComponent;
import com.example.copythatcainiao5play.presenter.BasePresenter;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.context.IconicsLayoutInflater2;
import com.mikepenz.iconics.utils.IconicsMenuInflaterUtil;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private Unbinder unbinder;

    private AppApplication appApplication;

    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        LayoutInflaterCompat.setFactory2(getLayoutInflater(),new IconicsLayoutInflater2(getDelegate()));

        super.onCreate(savedInstanceState);

        setContentView(setLayout());

        unbinder = ButterKnife.bind(this);

        this.appApplication=(AppApplication)getApplication();

        setUpActivityComponent(appApplication.getAppComponent());

        init();

    }

    public abstract int setLayout();

    public abstract void setUpActivityComponent(AppComponent appComponent);

    public abstract void init();

//    protected void startActivity(Class c){
//        this.startActivity(new Intent(this,c));
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=Unbinder.EMPTY){
            unbinder.unbind();
        }
    }
}
