package com.example.administrator.demo.Framework.imageloader;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageViewPagerActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.vp_imageloader_viewpager)
    ViewPager vpImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_pager);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitle.setText("ImageLoader应用在ViewPager中");

        vpImageloaderViewpager.setAdapter(new ImageLoaderViewPagerAdapter(this));
        vpImageloaderViewpager.setCurrentItem(0);
    }
}
