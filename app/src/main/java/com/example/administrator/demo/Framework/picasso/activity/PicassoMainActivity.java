package com.example.administrator.demo.Framework.picasso.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PicassoMainActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.btn_picasso_url)
    Button btnPicassoUrl;
    @Bind(R.id.btn_picasso_list)
    Button btnPicassoList;
    @Bind(R.id.btn_picasso_tranfromations)
    Button btnPicassoTranfromations;
    @Bind(R.id.iv_picasso1)
    ImageView ivPicasso1;
    @Bind(R.id.iv_picasso2)
    ImageView ivPicasso2;
    @Bind(R.id.iv_picasso3)
    ImageView ivPicasso3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_main);
        ButterKnife.bind(this);
        tvTitle.setText("Picasso的使用");
    }

    @OnClick({R.id.btn_picasso_url, R.id.btn_picasso_list, R.id.btn_picasso_tranfromations})
    public void onClick(View view) {
        switch (view.getId()) {
            /*加载图片的基本用法*/
            case R.id.btn_picasso_url:
                /*普通加载图片*/
                Picasso.with(this)
                        .load("http://ww2.sinaimg.cn/mw1024/6de27be0gw1f42apwwv4cj20qo0zk794.jpg")
                        .into(ivPicasso1);
                /*裁剪方式加载图片*/
                Picasso.with(this)
                        .load("http://ww2.sinaimg.cn/mw1024/6de27be0gw1f42apwwv4cj20qo0zk794.jpg")
                        .resize(100,100)//重新定义宽高
                        .into(ivPicasso2);
                /*旋转180度*/
                Picasso.with(this)
                        .load("http://ww2.sinaimg.cn/mw1024/6de27be0gw1f42apwwv4cj20qo0zk794.jpg")
                        .rotate(180)
                        .into(ivPicasso3);
                break;
            /*跳转到ListView页面加载图片*/
            case R.id.btn_picasso_list:
                startActivity(new Intent(this, PicassoListViewActivity.class));
                break;
            /*图片转换*/
            case R.id.btn_picasso_tranfromations:
                startActivity(new Intent(this, PicassoTranfromationsActivity.class));
                break;
        }
    }
}
