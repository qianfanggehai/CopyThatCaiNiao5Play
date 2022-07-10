package com.example.copythatcainiao5play.di.module;

import android.app.ProgressDialog;

import com.example.copythatcainiao5play.data.RecommendModel;
import com.example.copythatcainiao5play.data.http.ApiServer;
import com.example.copythatcainiao5play.presenter.RecommendPresenter;
import com.example.copythatcainiao5play.presenter.contract.RecommendContract;
import com.example.copythatcainiao5play.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {

    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view){
        this.mView=view;
    }

    @Provides
    public RecommendContract.View provideView(){
        return mView;
    }

    @Provides
    public RecommendModel provideModel(ApiServer apiServer){
        return new RecommendModel(apiServer);
    }


    @Provides
    public ProgressDialog provideProgressDialog(RecommendContract.View view){
        return new ProgressDialog(((RecommendFragment)view).getActivity());
    }
}
