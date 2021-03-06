package com.example.administrator.demo.Framework.customview.index;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wangyujie.
 * Data 2017/5/23
 * Time 20:55
 * TODO 快速索引
 * <p>
 * <p>
 * 步骤：
 * 1、把26个字母存入数组
 * 2、在onMeasure()计算itemHeight和itemWidth
 * 3、在onDraw()中绘制wordWidth、wordHeight、wordX、wordY
 * 手指按下变色
 * 1、重写onTouchEvent(),返回true,在down/move的过程中计算(要高亮的字母)
 * int touchIndex = Y / itemHeight;  强制绘制
 * <p>
 * 2、在onDraw()方法对下标设置画笔变色
 * <p>
 * 3、在up的时候
 * touchIntex = -1;
 * 强制绘制
 */

public class IndexView extends View {


    /**
     * 每个 item 的宽和高
     */
    private float itemWidth;
    private float itemHeight;

    private String[] words = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    private Paint paint;
    private OnIndexChangeListener listener;

    public IndexView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        paint.setAntiAlias(true);/*设置抗锯齿*/
        paint.setTypeface(Typeface.DEFAULT_BOLD);/*粗体字*/

    }

    /**
     * 测量方法
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*得到 item 的宽和高*/
        itemWidth = getMeasuredWidth();
        itemHeight = getMeasuredHeight() / words.length;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < words.length; i++) {
            if (touchIndex == i) {
                /*设置为灰色*/
                paint.setColor(Color.GRAY);
            } else {
                /*设置为白色*/
                paint.setColor(Color.WHITE);
            }
            String word = words[i];
            Rect rect = new Rect();
            /*画笔 0-1取一个字母*/
            paint.getTextBounds(word, 0, 1, rect);
            /*计算字母的高和宽*/
            int wordWidth = rect.width();
            int wordHeight = rect.height();
            /*计算每个字母在视图上的坐标位置*/
            float wordX = itemWidth / 2 - wordWidth / 2;
            float wordY = itemHeight / 2 + wordHeight / 2 + i * itemHeight;

            canvas.drawText(word, wordX, wordY, paint);
        }
    }


    /*子母的下标位置*/
    private int touchIndex = -1;

    /**
     * 手指按下变色
     * 1、重写onTouchEvent(),返回true,在down/move的过程中计算(要高亮的字母)
     * int touchIndex = Y / itemHeight;  强制绘制
     * <p>
     * 2、在onDraw()方法对下标设置画笔变色
     * <p>
     * 3、在up的时候
     * touchIntex = -1;
     * 强制绘制
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float Y = event.getY();
                /*子母的索引*/
                int index = (int) (Y / itemHeight);
                if (index != touchIndex) {
                    touchIndex = index;
                    invalidate();
                    if (listener != null && touchIndex < words.length) {
                        listener.onIndexChange(words[touchIndex]);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                touchIndex = -1;
                invalidate();
                break;
        }


        return true;
    }

    /**
     * 设置字母下标索引变化的监听
     * @param listener
     */
    public void setOnIndexChangeListener(OnIndexChangeListener listener) {
        this.listener = listener;
    }


    /**
     * 字母下标索引变化的监听器
     */
    public interface OnIndexChangeListener {
        /**
         * 当字母下标位置发生变化的时候回调
         * @param word
         */
        void onIndexChange(String word);
    }
}
