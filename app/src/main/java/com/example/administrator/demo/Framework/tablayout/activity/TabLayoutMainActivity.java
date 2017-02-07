package com.example.administrator.demo.Framework.tablayout.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.tablayout.adapter.ViewPagerAdapter;
import com.example.administrator.demo.Framework.tablayout.fragment.MyFragment;
import com.example.administrator.demo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TabLayoutMainActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tab_viewpager)
    ViewPager tabViewpager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    private ArrayList<MyFragment> fragments;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("TabLayout的使用");
        fragments = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            fragments.add(new MyFragment("标题" + i, "内容" + i, i + 1));
        }
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        tabViewpager.setAdapter(adapter);
        /*关联viewPager*/
        tabLayout.setupWithViewPager(tabViewpager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
