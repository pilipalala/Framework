package com.example.administrator.demo.Framework.imageloader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageLoaderActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.btn_imagelader_listview)
    Button btnImageladerListview;
    @Bind(R.id.btn_imagelader_gridview)
    Button btnImageladerGridview;
    @Bind(R.id.btn_imagelader_viewpager)
    Button btnImageladerViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        ButterKnife.bind(this);
        tvTitle.setText("imageloader");
    }

    @OnClick({R.id.btn_imagelader_listview, R.id.btn_imagelader_gridview, R.id.btn_imagelader_viewpager})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_imagelader_listview:
                /*跳转到listView案例页面*/
                startActivity(new Intent(this, ImageListViewActivity.class));
                break;
            case R.id.btn_imagelader_gridview:
                /*跳转到gridView案例页面*/
                startActivity(new Intent(this, ImageGridViewActivity.class));
                break;
            case R.id.btn_imagelader_viewpager:
                /*跳转到viewPager案例页面*/
                startActivity(new Intent(this, ImageViewPagerActivity.class));
                break;
        }
    }
}
