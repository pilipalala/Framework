package com.example.administrator.demo.Framework.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/3/28.
 */

public class MyViewPager extends ViewGroup {

    /**
     * 手势识别器
     * 1、定义出来
     * 2、实例化-把想要的方法重写
     * 3、在onTouchEvent()把事件传递给手势识别器
     */
    private GestureDetector detector;


    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(final Context context) {
        /*2、实例化手势识别器*/
        detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                Toast.makeText(context, "长按", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Toast.makeText(context, "双击", Toast.LENGTH_SHORT).show();
                return super.onDoubleTap(e);
            }

            /**
             * @param e1
             * @param e2
             * @param distanceX
             * @param distanceY
             * @return
             */
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Toast.makeText(context, "onScroll", Toast.LENGTH_SHORT).show();
                scrollBy((int) distanceX,getScrollY());
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        /*3、把事件传递给手势识别器*/
        detector.onTouchEvent(event);
        return true;
    }

    /**
     * @param changed
     * @param l       left
     * @param t       right
     * @param r       right
     * @param b       bottom
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        /*遍历孩子，给每个孩子指定在屏幕的坐标位置*/
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.layout(i * getWidth(), 0, (i + 1) * getWidth(), getHeight());
        }
    }
}
