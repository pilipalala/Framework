package com.example.administrator.demo.Framework.fresco.activity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FresoSpimgActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.sdv_freso_spimg)
    SimpleDraweeView sdvFresoSpimg;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freso_spimg);
        ButterKnife.bind(this);
        tvTitle.setText("带进度条的图片");

        /*设置样式*/
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder.setPlaceholderImage(new ProgressBarDrawable()).build();
        sdvFresoSpimg.setHierarchy(hierarchy);
        /*加载图片地址*/
        uri = Uri.parse("http://ww3.sinaimg.cn/mw1024/6de27be0gw1f42avxiha2j20qo0zk0zi.jpg");
        /*加载图片*/
        sdvFresoSpimg.setImageURI(uri);
    }
}
