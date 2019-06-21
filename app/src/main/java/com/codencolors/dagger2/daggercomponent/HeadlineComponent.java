package com.codencolors.dagger2.daggercomponent;

import com.codencolors.dagger2.activity.MainActivity;
import com.codencolors.dagger2.retrofit.ApiClient;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiClient.class})
public interface HeadlineComponent {

    void inject(MainActivity activity);
}
