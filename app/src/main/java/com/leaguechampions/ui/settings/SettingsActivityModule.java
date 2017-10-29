package com.leaguechampions.ui.settings;

import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsActivityModule {

    @Provides
    SettingsPresenter.SettingsView provideSettingsView(SettingsActivity activity) {
        return activity;
    }

    @Provides
    SettingsPresenter provideSettingsPresenter(SettingsPresenter.SettingsView view, SharedPreferences sharedPreferences) {
        return new SettingsPresenter(view, sharedPreferences);
    }
}
