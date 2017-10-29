package com.leaguechampions.ui.champions;

import com.leaguechampions.data.remote.Api;

import dagger.Module;
import dagger.Provides;

@Module
public class ChampionsActivityModule {

    @Provides
    ChampionsPresenter.ChampionsView provideChampionsView(ChampionsActivity championsActivity) {
        return championsActivity;
    }

    @Provides
    ChampionsPresenter provideChampionsPresenter(ChampionsPresenter.ChampionsView view, Api api) {
        return new ChampionsPresenter(view, api);
    }
}
