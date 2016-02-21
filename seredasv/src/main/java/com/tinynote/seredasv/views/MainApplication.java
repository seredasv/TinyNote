package com.tinynote.seredasv.views;

import android.app.Application;
import com.tinynote.seredasv.di.components.ApplicationComponent;
import com.tinynote.seredasv.di.components.DaggerApplicationComponent;
import com.tinynote.seredasv.di.modules.ApplicationModule;

public class MainApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        dependencyInjections();
    }

    private void dependencyInjections() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
