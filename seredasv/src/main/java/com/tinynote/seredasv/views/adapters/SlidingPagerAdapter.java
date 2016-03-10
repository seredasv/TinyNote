package com.tinynote.seredasv.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SlidingPagerAdapter extends FragmentPagerAdapter {
    public SlidingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
