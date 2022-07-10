package com.example.copythatcainiao5play;

import android.app.Application;
import android.content.Context;

import com.example.copythatcainiao5play.di.component.AppComponent;
import com.example.copythatcainiao5play.di.component.DaggerAppComponent;
import com.example.copythatcainiao5play.di.module.AppModule;
import com.example.copythatcainiao5play.di.module.HttpModule;

public class AppApplication extends Application {

    private AppComponent appComponent;

    public static AppApplication get(Context context){
        return (AppApplication)context.getApplicationContext();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().httpModule(new HttpModule())
                .appModule(new AppModule(this))
                .build();
    }
}
