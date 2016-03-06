package com.tinynote.seredasv.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import com.tinynote.seredasv.R;
import com.tinynote.seredasv.views.MainApplication;
import com.tinynote.seredasv.views.fragments.NotesFragment;
import org.androidannotations.annotations.*;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private static final String NOTES_TOOLBAR_TITLE = "Notes";
    @ViewById(R.id.container)
    protected FrameLayout container;
    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;
    private Bundle savedInstanceState;

    @AfterInject
    protected void afterInject() {
        ((MainApplication) getApplication()).getComponent().inject(this);
    }

    @AfterViews
    protected void afterViews() {
        openNotesFragment();
    }

    @UiThread
    protected void openNotesFragment() {
        if (savedInstanceState == null) {
            openFragment(NotesFragment.newInstance(NOTES_TOOLBAR_TITLE), true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.savedInstanceState = savedInstanceState;
    }

    private void openFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                    .commit();
        } else {
            transaction.replace(R.id.container, fragment).commit();
        }
    }
}
