package com.example.copythatcainiao5play.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.copythatcainiao5play.AppApplication;
import com.example.copythatcainiao5play.R;
import com.example.copythatcainiao5play.di.component.AppComponent;
import com.example.copythatcainiao5play.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private Unbinder unbinder;

    private AppApplication appApplication;

    @Inject
    T mPresenter;

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.i("TAG", "onCreateView: ");
        mRootView = inflater.inflate(setLayout(), container, false);

        unbinder = ButterKnife.bind(this, mRootView);

        return mRootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.appApplication= (AppApplication) getActivity().getApplication();

        setUpActivityComponent(appApplication.getAppComponent());

        init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder!=Unbinder.EMPTY){
            unbinder.unbind();
        }
    }

    public abstract int setLayout();

    public abstract void setUpActivityComponent(AppComponent appComponent);

    public abstract void init();

}
