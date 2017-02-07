package com.example.administrator.demo.Framework.fresco.activity;

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

public class FrescoMainActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.bt_fresco_spimg)
    Button btFrescoSpimg;
    @Bind(R.id.bt_fresco_crop)
    Button btFrescoCrop;
    @Bind(R.id.bt_fresco_circleAndCorner)
    Button btFrescoCircleAndCorner;
    @Bind(R.id.bt_fresco_jpeg)
    Button btFrescoJpeg;
    @Bind(R.id.bt_fresco_gif)
    Button btFrescoGif;
    @Bind(R.id.bt_fresco_multi)
    Button btFrescoMulti;
    @Bind(R.id.bt_fresco_listener)
    Button btFrescoListener;
    @Bind(R.id.bt_fresco_resize)
    Button btFrescoResize;
    @Bind(R.id.bt_fresco_modifyImg)
    Button btFrescoModifyImg;
    @Bind(R.id.bt_fresco_autoSizeImg)
    Button btFrescoAutoSizeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_main);
        ButterKnife.bind(this);
        tvTitle.setText("Fresco的使用");
    }

    @OnClick({R.id.bt_fresco_spimg, R.id.bt_fresco_crop, R.id.bt_fresco_circleAndCorner, R.id.bt_fresco_jpeg, R.id.bt_fresco_gif, R.id.bt_fresco_multi, R.id.bt_fresco_listener, R.id.bt_fresco_resize, R.id.bt_fresco_modifyImg, R.id.bt_fresco_autoSizeImg})
    public void onClick(View view) {
        switch (view.getId()) {
            /*带进度条的图片*/
            case R.id.bt_fresco_spimg:
                startActivity(new Intent(this,FresoSpimgActivity.class));
                break;
            /*图片的不同裁剪*/
            case R.id.bt_fresco_crop:
                startActivity(new Intent(this,FresoCropActivity.class));
                break;
            /*圆形和圆角图片*/
            case R.id.bt_fresco_circleAndCorner:
                startActivity(new Intent(this,FresoCircleAndCornerActivity.class));
                break;
            /*渐进式展示图片*/
            case R.id.bt_fresco_jpeg:
                startActivity(new Intent(this,FresoJpegActivity.class));
                break;
            /*GIF动画图片*/
            case R.id.bt_fresco_gif:
                startActivity(new Intent(this,FresoGifActivity.class));
                break;
            /*多图请求及图片复用*/
            case R.id.bt_fresco_multi:
                startActivity(new Intent(this,FresoMultiActivity.class));
                break;
            /*图片加载监听*/
            case R.id.bt_fresco_listener:
                startActivity(new Intent(this,FresoListenerActivity.class));
                break;
            /*图片修改和旋转*/
            case R.id.bt_fresco_resize:
                startActivity(new Intent(this,FresoresizeActivity.class));
                break;
            /*修改图片*/
            case R.id.bt_fresco_modifyImg:
                startActivity(new Intent(this,FresoModifyImgActivity.class));
                break;
            /*动态展示图片*/
            case R.id.bt_fresco_autoSizeImg:
                startActivity(new Intent(this,FresoAutoSizeActivity.class));
                break;
        }
    }
}
