package com.leaguechampions;

import android.app.Activity;
import android.app.Application;

import com.leaguechampions.injection.AppComponent;
import com.leaguechampions.injection.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class LeagueChampions extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
        appComponent.inject(this);

//        Picasso.setSingletonInstance(appComponent.getPicasso());
    }
}
