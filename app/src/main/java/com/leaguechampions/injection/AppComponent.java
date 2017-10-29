package com.leaguechampions.injection;

import android.app.Application;

import com.leaguechampions.LeagueChampions;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        DataModule.class,
        ActivityBuilder.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(LeagueChampions app);

    //    Picasso getPicasso();
}
