package com.example.copythatcainiao5play.data.http;

import com.example.copythatcainiao5play.bean.PageBean;
import com.example.copythatcainiao5play.bean.TypeBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiServer {
    public static final String Base_Url="http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    public Call<PageBean<TypeBean>> getApps(@Query("p") String jsonParam);

//    @GET("featured")
//    public Observable<PageBean<TypeBean>> getApps(@Query("p") String jsonParam);
}
