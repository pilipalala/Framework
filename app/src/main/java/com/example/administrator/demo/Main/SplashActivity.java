package com.example.administrator.demo.Main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2016/9/30.
 */
public class SplashActivity extends Activity {
    private LinearLayout ll_splsh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }
    public void initView(){


    }
}
