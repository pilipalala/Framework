package com.example.administrator.demo.Framework.glide.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.glide.adapter.GlideTranfromationsAdapter;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GlideTranfromationsActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_glide_transformations)
    RecyclerView rvGlideTransformations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_tranfromations);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitle.setText("图片转换");
        rvGlideTransformations.setAdapter(new GlideTranfromationsAdapter(this));
        rvGlideTransformations.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
