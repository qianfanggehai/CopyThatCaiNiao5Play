package com.example.copythatcainiao5play.di.module;

import com.example.copythatcainiao5play.bean.PageBean;
import com.example.copythatcainiao5play.bean.TypeBean;
import com.example.copythatcainiao5play.data.http.ApiServer;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

@Module
public class HttpModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){

        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(ApiServer.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())//自动解析成javaBean:<PageBean<TypeBean>> : @GET("featured") public Call<PageBean<TypeBean>> getApps(@Query("p") String jsonParam);
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//适配rxjava
                .client(okHttpClient);
        return builder.build();
    }

    @Provides
    @Singleton
    public ApiServer provideApiServer(Retrofit retrofit){
        return retrofit.create(ApiServer.class);
    }
}
