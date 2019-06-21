package com.codencolors.dagger2;

import android.app.Application;

import com.codencolors.dagger2.daggercomponent.DaggerHeadlineComponent;
import com.codencolors.dagger2.daggercomponent.HeadlineComponent;
import com.codencolors.dagger2.retrofit.ApiClient;

import javax.inject.Inject;

public class NewsApplication extends Application {

    private HeadlineComponent headlineComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        headlineComponent = DaggerHeadlineComponent.builder()
                .apiClient(new ApiClient(Helper.URL))
                .build();
    }

    @Inject
    public HeadlineComponent getHeadlineComponent() {
        return headlineComponent;
    }
}
