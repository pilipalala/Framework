package com.example.administrator.demo.Framework.materialdesign.recyclerview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2017/2/23.
 */
public class PaletteAdapter extends FragmentPagerAdapter {
    private final Context context;
    private String[] tabTitles;

    public PaletteAdapter(FragmentManager manager, String[] tabTitles, Context context) {
        super(manager);
        this.tabTitles = tabTitles;
        this.context = context;

    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        return PaletteFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];

    }
}
