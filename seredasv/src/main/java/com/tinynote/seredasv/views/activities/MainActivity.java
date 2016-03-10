package com.tinynote.seredasv.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.tinynote.seredasv.R;
import com.tinynote.seredasv.helpers.sliding_tab.SlidingTabLayout;
import com.tinynote.seredasv.views.MainApplication;
import com.tinynote.seredasv.views.fragments.CategoriesFragment;
import com.tinynote.seredasv.views.fragments.LocationsFragment;
import com.tinynote.seredasv.views.fragments.NotesFragment;
import com.tinynote.seredasv.views.fragments.TagsFragment;
import org.androidannotations.annotations.*;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private static final String NOTES_TOOLBAR_TITLE = "Notes";
    @ViewById(R.id.toolbar)
    public Toolbar toolbar;
    @ViewById(R.id.container)
    protected FrameLayout container;
    private Bundle savedInstanceState;
    private Drawer drawer;

    @AfterInject
    protected void afterInject() {
        ((MainApplication) getApplication()).getComponent().inject(this);
    }

    @AfterViews
    protected void afterViews() {
        setSupportActionBar(toolbar);

        createDrawer();
        openNotesFragment();
    }

    @UiThread
    protected void openNotesFragment() {
        if (savedInstanceState == null) {
            openFragment(NotesFragment.newInstance(NOTES_TOOLBAR_TITLE), true);
        }
    }

    private void createDrawer() {
        SecondaryDrawerItem notes = new SecondaryDrawerItem().withName("Notes").withIcon(android.R.drawable.ic_delete).withIdentifier(0);
        SecondaryDrawerItem categories = new SecondaryDrawerItem().withName("Categories").withIcon(android.R.drawable.ic_delete).withIdentifier(1);
        SecondaryDrawerItem tags = new SecondaryDrawerItem().withName("Tags").withIcon(android.R.drawable.ic_delete).withIdentifier(2);
        SecondaryDrawerItem locations = new SecondaryDrawerItem().withName("Locations").withIcon(android.R.drawable.ic_delete).withIdentifier(3);
        SecondaryDrawerItem exit = new SecondaryDrawerItem().withName("Exit").withIcon(android.R.drawable.ic_delete).withIdentifier(4);
        DividerDrawerItem divider = new DividerDrawerItem();

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        notes,
                        categories,
                        tags,
                        locations,
                        divider,
                        exit
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int) drawerItem.getIdentifier()) {
                            case 0:
                                openFragment(NotesFragment.newInstance("Notes"), true);
                                break;
                            case 1:
                                openFragment(CategoriesFragment.newInstance("Categories"), true);
                                break;
                            case 2:
                                openFragment(TagsFragment.newInstance("Tags"), true);
                                break;
                            case 3:
                                openFragment(LocationsFragment.newInstance("Locations"), true);
                                break;
                            case 4:
                                finish();
                                break;
                        }
                        drawer.closeDrawer();
                        return true;
                    }
                })
                .build();
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
