package com.example.administrator.demo.Framework.customview;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomViewMainActivity extends BaseActivity {

    @Bind(R.id.my_viewPager)
    MyViewPager myViewPager;
    private int[] images = {R.mipmap.check, R.mipmap.demo};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_main);
        ButterKnife.bind(this);
        /*添加页面*/
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(images[i]);
            /*添加到viewPager这个view中*/
            myViewPager.addView(imageView);
        }
    }
}
