package com.example.copythatcainiao5play.di.component;

import com.example.copythatcainiao5play.di.FragmentScope;
import com.example.copythatcainiao5play.di.module.RecommendModule;
import com.example.copythatcainiao5play.ui.fragment.RecommendFragment;

import dagger.Component;

@FragmentScope
@Component(modules = RecommendModule.class,dependencies = AppComponent.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);
}
