package com.example.administrator.demo.Framework.glide.activity;

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

public class GlideMainActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.btn_glide_base)
    Button btnGlideBase;
    @Bind(R.id.btn_glide_recycleview)
    Button btnGlideRecycleview;
    @Bind(R.id.btn_glide_tranfromations)
    Button btnGlideTranfromations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_main);
        ButterKnife.bind(this);
        tvTitle.setText("Glide的使用");
    }

    @OnClick({R.id.btn_glide_base, R.id.btn_glide_recycleview, R.id.btn_glide_tranfromations})
    public void onClick(View view) {
        switch (view.getId()) {
            /*基本使用*/
            case R.id.btn_glide_base:
                startActivity(new Intent(this, GlideBaseActivity.class));
                break;
            /*在RecycleView中加载图片*/
            case R.id.btn_glide_recycleview:
                startActivity(new Intent(this, GlideRecycleViewActivity.class));
                break;
            /*图片转换*/
            case R.id.btn_glide_tranfromations:
                startActivity(new Intent(this, GlideTranfromationsActivity.class));
                break;
        }
    }
}
