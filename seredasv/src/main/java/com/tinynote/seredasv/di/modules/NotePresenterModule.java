package com.tinynote.seredasv.di.modules;

import com.tinynote.seredasv.presenters.notes.NotePresenter;
import com.tinynote.seredasv.presenters.notes.NotePresenterImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class NotePresenterModule {
    @Provides
    @Singleton
    NotePresenter provideNotePresenter(NotePresenterImpl notePresenter) {
        return notePresenter;
    }
}
