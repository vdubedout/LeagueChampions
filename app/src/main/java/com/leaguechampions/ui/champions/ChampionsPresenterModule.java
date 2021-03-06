package com.leaguechampions.ui.champions;

import dagger.Module;
import dagger.Provides;

@Module
public class ChampionsPresenterModule {

    private final ChampionsPresenter.ChampionsView view;

    public ChampionsPresenterModule(ChampionsPresenter.ChampionsView view) {
        this.view = view;
    }

    @Provides
    public ChampionsPresenter.ChampionsView provideView() {
        return view;
    }
}
