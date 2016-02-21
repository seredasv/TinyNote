package com.tinynote.seredasv.di.components;

import com.tinynote.seredasv.di.modules.ApplicationModule;
import com.tinynote.seredasv.views.activities.MainActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
