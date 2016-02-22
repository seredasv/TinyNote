package com.tinynote.seredasv.di.modules;

import com.tinynote.seredasv.presenters.categories.CategoryPresenter;
import com.tinynote.seredasv.presenters.categories.CategoryPresenterImpl;
import com.tinynote.seredasv.presenters.navigationDrawerPresenter.NavigationDrawerPresenter;
import com.tinynote.seredasv.presenters.navigationDrawerPresenter.NavigationDrawerPresenterImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class NavigationDrawerPresenterModule {
    @Provides
    @Singleton
    NavigationDrawerPresenter provideNavigationDrawerPresenter(NavigationDrawerPresenterImpl drawerPresenter) {
        return drawerPresenter;
    }
}
