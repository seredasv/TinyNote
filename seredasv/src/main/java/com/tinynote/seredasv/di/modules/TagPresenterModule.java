package com.tinynote.seredasv.di.modules;

import com.tinynote.seredasv.presenters.tags.TagPresenter;
import com.tinynote.seredasv.presenters.tags.TagPresenterImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class TagPresenterModule {
    @Provides
    @Singleton
    TagPresenter provideTagPresenter(TagPresenterImpl tagPresenter) {
        return tagPresenter;
    }
}
