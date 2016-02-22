package com.tinynote.seredasv.views;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.tinynote.seredasv.di.components.ApplicationComponent;
import com.tinynote.seredasv.di.components.DaggerApplicationComponent;
import com.tinynote.seredasv.di.modules.*;

import javax.inject.Inject;

public class MainApplication extends Application {
    @Inject
    Context context;

    @Inject
    SharedPreferences sharedPreferences;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        dependencyInjections();
    }

    private void dependencyInjections() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .categoryPresenterModule(new CategoryPresenterModule())
                .locationPresenterModule(new LocationPresenterModule())
                .navigationDrawerPresenterModule(new NavigationDrawerPresenterModule())
                .notePresenterModule(new NotePresenterModule())
                .settingPresenterModule(new SettingPresenterModule())
                .tagPresenterModule(new TagPresenterModule())
                .build();

        getComponent().inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
