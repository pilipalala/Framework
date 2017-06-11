package com.example.administrator.demo.Framework.guanggaotiao;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PhotoViewActivity extends BaseActivity {

    @Bind(R.id.view_pager)
    HackyViewPager viewPager;
    @Bind(R.id.toolbar1)
    Toolbar toolbar1;
    @Bind(R.id.tab_viewpager)
    TextView tabViewpager;
    private ArrayList<String> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        ButterKnife.bind(this);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        int position = getIntent().getIntExtra("position", 0);
        imageList = new ArrayList<>();
        String[] urls = getResources().getStringArray(R.array.url4);
        for (int i = 0; i < urls.length; i++) {
            imageList.add(urls[i]);
        }
        viewPager.setAdapter(new SamplePagerAdapter(this, imageList));
        viewPager.setCurrentItem(position - 1);
        tabViewpager.setText((position)+"/"+imageList.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabViewpager.setText((position+1)+"/"+imageList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
