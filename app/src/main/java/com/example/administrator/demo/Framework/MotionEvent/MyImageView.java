package com.example.administrator.demo.Framework.MotionEvent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by wangyujie
 * Date 2017/7/10
 * Time 23:07
 * TODO
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView{
    private static final String TAG = "WANGYUJIE";

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG, "MyImageView: " );
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent: " +event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: " + event.getAction());
        return super.onTouchEvent(event);

    }
}
