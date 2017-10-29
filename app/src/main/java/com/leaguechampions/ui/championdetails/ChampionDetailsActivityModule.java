package com.leaguechampions.ui.championdetails;

import com.leaguechampions.data.remote.Api;

import dagger.Module;
import dagger.Provides;

@Module
public class ChampionDetailsActivityModule {

    @Provides
    ChampionDetailsPresenter.ChampionDetailsView provideChampionDetailsView(ChampionDetailsActivity activity) {
        return activity;
    }

    @Provides
    ChampionDetailsPresenter provideChampionDetailsPresenter(ChampionDetailsPresenter.ChampionDetailsView view, Api api) {
        return new ChampionDetailsPresenter(view, api);
    }
}
