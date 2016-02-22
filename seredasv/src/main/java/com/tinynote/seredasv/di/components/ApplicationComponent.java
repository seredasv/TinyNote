package com.tinynote.seredasv.di.components;

import com.tinynote.seredasv.di.modules.*;
import com.tinynote.seredasv.views.MainApplication;
import com.tinynote.seredasv.views.activities.MainActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class, CategoryPresenterModule.class, LocationPresenterModule.class,
        NavigationDrawerPresenterModule.class, NotePresenterModule.class, SettingPresenterModule.class,
        TagPresenterModule.class})
public interface ApplicationComponent {
    void inject(MainApplication application);

    void inject(MainActivity activity);
}
