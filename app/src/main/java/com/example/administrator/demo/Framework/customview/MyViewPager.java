package com.example.administrator.demo.Framework.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.Toast;


/**
 * Created by Administrator on 2017/3/28.
 */

public class
MyViewPager extends ViewGroup {

    /**
     * 手势识别器
     * 1、定义出来
     * 2、实例化-把想要的方法重写
     * 3、在onTouchEvent()把事件传递给手势识别器
     */
    private GestureDetector detector;
    /*当前页面的下标位置*/
    private int currentIndex;
    private Scroller myScroller;
    onPagerChangerListener onPagerChangerListener;
    private float downX;
    private float downY;

    //    private MyScroller myScroller;
    public interface onPagerChangerListener {
        public void onScrollToPager(int currentIndex);
    }

    public void setOnPagerChangerListener(onPagerChangerListener onPagerChangerListener) {
        this.onPagerChangerListener = onPagerChangerListener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(final Context context) {
        myScroller = new Scroller(context);
//        myScroller = new MyScroller();
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
             * @param distanceX 在X轴滑动了的距离
             * @param distanceY 在Y轴滑动了的距离
             * @return
             */
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Toast.makeText(context, "onScroll", Toast.LENGTH_SHORT).show();
                /**
                 * X 要在X轴平移的距离
                 * Y 要在Y轴移动的距离
                 */
                scrollBy((int) distanceX, getScrollY());
                return true;
            }
        });
    }

    float startX;
    float eventX;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = false;//默认传递给孩子
        detector.onTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /*记录起始坐标*/
                downX = ev.getX();
                downY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                /*计算结束坐标*/
                float endDownX = ev.getX();
                float endDownY = ev.getY();
                /*计算绝对值*/
                float distanceX = Math.abs(endDownX - downX);
                float distanceY = Math.abs(endDownY - downY);
                if (distanceX > distanceY && distanceX > 5) {
                    result = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }


        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        /*3、件传递给手势识别器*/
        detector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:


                break;
            case MotionEvent.ACTION_UP:
                eventX = event.getX();
                int tempIndex = currentIndex;
                if (startX - eventX > getWidth() / 2) {
                    /*切换到下一页*/
                    tempIndex++;
                } else if (eventX - startX > getWidth() / 2) {
                    /*切换到上一页*/
                    tempIndex--;
                }
                /*根据下标  位置移动到指定的页面*/
                scrollToPager(tempIndex);


                break;
        }

        return true;
    }

    /**
     * 屏蔽非法值
     *
     * @param tempIndex
     */
    public void scrollToPager(int tempIndex) {
        if (tempIndex < 0) {
            tempIndex = 0;
        } else if (tempIndex > getChildCount() - 1) {
            tempIndex = getChildCount() - 1;
        }

       /*当前页面的下标位置*/
        currentIndex = tempIndex;
        if (onPagerChangerListener != null) {
            onPagerChangerListener.onScrollToPager(currentIndex);
        }

        /*总距离计算出来*/
        int distanceX = currentIndex * getWidth() - getScrollX();
        /*移动到指定位置*/
//       scrollTo(currentIndex * getWidth(), getScrollY());

        myScroller.startScroll(getScrollX(), getScrollY(), distanceX, 0, Math.abs(distanceX));
//        myScroller.startScroll(getScrollX(), getScrollY(), distanceX, 0);

        invalidate();/*导致 onDraw() computeScroll()方法执行  */
    }
/**
 *  myScroller.startScroll(getScrollX(), getScrollY(), distanceX, 0);----->invalidate();----->computeScroll()---
 *
 *
 *
 *
 *  ----->myScroller.cuputeScrollOffset()----->float currX = myScroller.getCurrX();----->scrollTo((int) currX, 0);----->invalidate();
 *
 *
 *
 */
    /**
     * 计算滑动
     */
    @Override
    public void computeScroll() {
//        super.computeScroll();
        if (myScroller.computeScrollOffset()) {
//        if (myScroller.computeScrollOffset()) {
            float currX = myScroller.getCurrX();
            scrollTo((int) currX, 0);
            invalidate();
        }
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
