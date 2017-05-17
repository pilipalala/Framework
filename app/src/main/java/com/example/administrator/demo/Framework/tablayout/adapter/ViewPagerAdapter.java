package com.example.administrator.demo.Framework.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.demo.Framework.tablayout.fragment.MyFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/3.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fragments;
    private String[] tabTitles;
    private ArrayList<MyFragment> myFragments;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, String[] tabTitles) {
        super(fm);
        this.fragments = fragments;
        this.tabTitles = tabTitles;
    }

    public ViewPagerAdapter(FragmentManager fm, ArrayList<MyFragment> myFragments) {
        super(fm);
        this.myFragments = myFragments;

    }

    @Override
    public Fragment getItem(int position) {
        if (fragments == null) {
            return myFragments.get(position);
        } else {
            return fragments.get(position);
        }
    }

    @Override
    public int getCount() {
        if (fragments == null) {
            return myFragments.size();
        } else {
            return fragments.size();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (tabTitles == null) {
            return myFragments.get(position).getTitle();
        } else {
            return tabTitles[position];
        }
    }
}
