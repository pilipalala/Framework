package com.example.administrator.demo.Framework.customview.viewpage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomViewMainActivity extends BaseActivity {

    @Bind(R.id.my_viewPager)
    MyViewPager myViewPager;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
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

        /*添加测试页面*/
        View testView = View.inflate(this,R.layout.text_custom_view, null);
        myViewPager.addView(testView);

        for (int i = 0; i < myViewPager.getChildCount(); i++) {
            RadioButton button = new RadioButton(this);
            button.setId(i);//0-5的id
            if (i == 0) {
                button.setChecked(true);
            }
            /*添加到RadioGroup*/
            rgMain.addView(button);
        }
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /**
             *
             * @param radioGroup
             * @param i
             */
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                myViewPager.scrollToPager(i);
            }
        });
        myViewPager.setOnPagerChangerListener(new MyViewPager.onPagerChangerListener() {
            @Override
            public void onScrollToPager(int currentIndex) {
                rgMain.check(currentIndex);
            }
        });
    }
}
