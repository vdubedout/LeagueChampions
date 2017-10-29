package com.leaguechampions.injection;

import com.leaguechampions.ui.championdetails.ChampionDetailsActivity;
import com.leaguechampions.ui.championdetails.ChampionDetailsActivityModule;
import com.leaguechampions.ui.champions.ChampionsActivity;
import com.leaguechampions.ui.champions.ChampionsActivityModule;
import com.leaguechampions.ui.settings.SettingsActivity;
import com.leaguechampions.ui.settings.SettingsActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {ChampionsActivityModule.class})
    abstract ChampionsActivity contributesChampionsActivity();

    @ContributesAndroidInjector(modules = {ChampionDetailsActivityModule.class})
    abstract ChampionDetailsActivity contributesChampionDetailsActivity();

    @ContributesAndroidInjector(modules = {SettingsActivityModule.class})
    abstract SettingsActivity contributesSettingsActivity();
}

