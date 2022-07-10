package com.example.copythatcainiao5play.di.module;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application){
        this.application=application;
    }
    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }
    @Provides
    @Singleton
    public Gson provideGson(){
        return new Gson();
    }
}
