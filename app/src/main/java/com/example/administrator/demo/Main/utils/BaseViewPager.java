package com.example.administrator.demo.Main.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 自定义高度的viewpapger
 */
public class BaseViewPager extends ViewPager {
    private boolean scrollable = true;

    public BaseViewPager(Context context) {
        super(context);
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*
    * 设置viewpager是否可以滚动
    * */
    public void setScrollable(boolean enable) {
        scrollable = enable;
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        if (scrollable)
            return super.onInterceptHoverEvent(event);
        else
            return false;
    }
}
