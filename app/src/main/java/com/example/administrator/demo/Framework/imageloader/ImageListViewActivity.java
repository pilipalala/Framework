package com.example.administrator.demo.Framework.imageloader;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageListViewActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_imageLoader)
    ListView lvImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list_view);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitle.setText("ImageLoader应用在ListView中");
        lvImageLoader.setAdapter(new ImageLoaderListViewAdapter(this));
    }
}
