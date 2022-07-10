package com.example.copythatcainiao5play.data;

import com.example.copythatcainiao5play.bean.PageBean;
import com.example.copythatcainiao5play.bean.TypeBean;
import com.example.copythatcainiao5play.data.http.ApiServer;

import retrofit2.Call;
import retrofit2.Callback;
import rx.Observable;

public class RecommendModel {

    private ApiServer apiServer;

    public RecommendModel(ApiServer apiServer){
        this.apiServer=apiServer;
    }

    public void getApps(Callback<PageBean<TypeBean>> callback){
//        HttpManager manager = new HttpManager();
//        ApiServer apiServer = manager.getRetrofit(manager.getOkHttpClient()).create(ApiServer.class);
//
//        Call<PageBean<TypeBean>> apps = apiServer.getApps("{'page':0}");
//        apps.enqueue(callback);

        apiServer.getApps("{'page':0}").enqueue(callback);

    }
}
