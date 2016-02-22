package com.tinynote.seredasv.di.modules;

import com.tinynote.seredasv.presenters.locations.LocationPresenter;
import com.tinynote.seredasv.presenters.locations.LocationPresenterImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class LocationPresenterModule {
    @Provides
    @Singleton
    LocationPresenter provideLocationPresenter(LocationPresenterImpl locationPresenter) {
        return locationPresenter;
    }
}
