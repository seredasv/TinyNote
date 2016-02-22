package com.tinynote.seredasv.di.modules;

import com.tinynote.seredasv.presenters.categories.CategoryPresenter;
import com.tinynote.seredasv.presenters.categories.CategoryPresenterImpl;
import com.tinynote.seredasv.presenters.settings.SettingPresenter;
import com.tinynote.seredasv.presenters.settings.SettingPresenterImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class SettingPresenterModule {
    @Provides
    @Singleton
    SettingPresenter provideSettingPresenter(SettingPresenterImpl settingPresenter) {
        return settingPresenter;
    }
}
