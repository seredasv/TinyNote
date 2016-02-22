package com.tinynote.seredasv.views.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tinynote.seredasv.R;
import com.tinynote.seredasv.views.MainApplication;
import com.tinynote.seredasv.views.fragments.NotesFragment;
import org.androidannotations.annotations.*;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private static final String NOTES_TOOLBAR_TITLE = "Notes";
    @ViewById(R.id.container)
    protected FrameLayout container;
    @ViewById(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;
    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;
    @ViewById(R.id.drawer)
    protected RelativeLayout drawer;
    private Bundle savedInstanceState;
    private ActionBarDrawerToggle drawerToggle;
    private float lastTranslate = 0.0f;

    @AfterInject
    protected void afterInject() {
        ((MainApplication) getApplication()).getComponent().inject(this);
    }

    @AfterViews
    protected void afterViews() {
        createToolbar();
        createNavigationDrawer();
        openNotesFragment();
    }

    private void createToolbar() {
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
//            toolbar.setTitle();
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO open drawer here
                }
            });
        }
    }

    private void createNavigationDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (drawer.getWidth() * slideOffset);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    container.setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    container.startAnimation(anim);

                    lastTranslate = moveFactor;
                }
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                supportInvalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.syncState();
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
