package com.example.copythatcainiao5play.di.component;

import com.example.copythatcainiao5play.data.http.ApiServer;
import com.example.copythatcainiao5play.di.module.AppModule;
import com.example.copythatcainiao5play.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public ApiServer getApiServer();
}
