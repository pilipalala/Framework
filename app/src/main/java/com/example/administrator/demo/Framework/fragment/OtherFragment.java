package com.example.administrator.demo.Framework.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseFragment;

/**
 * Created by Administrator on 2016/12/13.
 */
public class OtherFragment extends BaseFragment {

    private TextView textView;
    private static final String TAG = "CustomFragment";

    @Override
    protected View initView() {
        Log.e(TAG, "其他页面初始化了...");
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    protected void initData() {
        Log.e(TAG,"其他数据初始化了...");
        super.initData();
        textView.setText("其他的世界！！！");

    }
}
