package com.example.administrator.demo.Framework.customview.viewpage;


import android.os.SystemClock;

/**
 * Created by wangyujiew .
 * Data 2017/3/30
 * Time 23:17
 */

public class MyScroller {
    /*起始坐标*/
    private float startX;
    private float startY;

    /*在X轴上要移动的距离*/
    private int distanceX;
    /*在X轴上要移动的距离*/
    private int distanceY;
    /*开始时间*/
    private long startTime;
    /*总时间*/
    private long totalTime = 500;
    /*是否移动完成、
    * false 没有移动完成
    *
    * true 移动结束
    * */
    private boolean isFinsh;

    public float getCurrX() {
        return currX;
    }

    private float currX;


    public void startScroll(float startX, float startY, int distanceX, int distanceY) {

        this.startX = startX;
        this.startY = startY;
        this.distanceX = distanceX;
        this.distanceY = distanceY;
        this.startTime = SystemClock.uptimeMillis();//系统开机时间
        this.isFinsh = false;
    }


    /**
     * 判断是否正在移动
     *
     * @reurn false 移动结束 true正在移动
     */
    public  boolean computeScrollOffset() {
        if (isFinsh) {
            return false;
        }
        long endTime = SystemClock.uptimeMillis();
        /*这一小段花费的时间*/
        long passTime = endTime - startTime;

        if (passTime < totalTime) {
            /*还没移动结束*/

            /*计算平均速度*/
//            float voleCity = distanceX / totalTime;
            /*在移动这一小段对应的距离*/
            float distanceSamllX = passTime * distanceX / totalTime;

            /*移动这一小段后对应的X轴坐标*/
             currX = startX + distanceSamllX;

        } else {
            /*移动结束*/
            isFinsh = true;
            currX = startX + distanceX;

        }
        return true;
    }

}
