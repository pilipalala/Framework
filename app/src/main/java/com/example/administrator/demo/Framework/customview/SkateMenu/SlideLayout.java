package com.example.administrator.demo.Framework.customview.SkateMenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by wangyujie
 * Date 2017/6/5
 * Time 22:19
 * TODO 侧滑菜单item
 */

public class SlideLayout extends FrameLayout {
    private View contentView;
    private View menuView;
    /**
     * content 的宽
     */
    private int contentWidth;
    /**
     * menu 的宽
     */
    private int menuWidth;
    private int viewHeight;
    private int toScrollX;

    public SlideLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 当布局文件加载完成的时候回调这个方法
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        contentView = getChildAt(0);
        menuView = getChildAt(1);
    }

    /**
     * 测量的时候得到宽和高
     * <p>
     * 在onMeasure()方法中
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        contentWidth = contentView.getMeasuredWidth();
        menuWidth = menuView.getMeasuredWidth();
        viewHeight = getMeasuredHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        /**
         * 指定菜单的位置
         * */
        menuView.layout(contentWidth, 0, contentWidth + menuWidth, viewHeight);
    }

    private float startX;
    private float startY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /*1.按下记录坐标值*/
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                /*2.记录结束值*/
                float endX = event.getX();
                float endY = event.getY();

                /*3.计算偏移量*/

                float distanceX = endX - startX;
                Log.e(TAG, "onTouchEvent: "+getScaleX() );

                toScrollX = (int) (getScrollX() - distanceX);
                Log.e(TAG, "toScrollX: "+toScrollX );
                if (toScrollX < 0) {
                    toScrollX = 0;
                } else if (toScrollX > menuWidth) {
                    toScrollX = menuWidth;
                }
                scrollTo(toScrollX, getScrollY());

                break;
            case MotionEvent.ACTION_UP:

                break;

        }

        return true;


    }
}
