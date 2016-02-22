package com.tinynote.seredasv.di.modules;

import com.tinynote.seredasv.presenters.categories.CategoryPresenter;
import com.tinynote.seredasv.presenters.categories.CategoryPresenterImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class CategoryPresenterModule {
    @Provides
    @Singleton
    CategoryPresenter provideCategoryPresenter(CategoryPresenterImpl categoryPresenter) {
        return categoryPresenter;
    }
}
