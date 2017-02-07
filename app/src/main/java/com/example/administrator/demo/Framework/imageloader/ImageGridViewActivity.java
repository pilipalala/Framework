package com.example.administrator.demo.Framework.imageloader;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageGridViewActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.gv_imageloader)
    GridView gvImageloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid_view);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitle.setText("imageLoader应用在GridView中");
        gvImageloader.setAdapter(new ImageLoaderGridViewAdapter(this));
    }
}
