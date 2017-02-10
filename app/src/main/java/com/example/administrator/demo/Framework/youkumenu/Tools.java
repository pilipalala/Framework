package com.example.administrator.demo.Framework.youkumenu;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * Created by Administrator on 2017/1/16.
 */
public class Tools {

    public static void hideView(ViewGroup view) {
        hideView(view,0);
    }

    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    public static void hideView(ViewGroup view, int time) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
        rotateAnimation.setDuration(1000);//设置动画播放持续时间
        rotateAnimation.setStartOffset(time);//动画停留在播放完成的状态
        rotateAnimation.setFillAfter(true);//延迟time ms后播放动画
        view.startAnimation(rotateAnimation);
        for (int i = 0; i < view.getChildCount(); i++) {
            View childen = view.getChildAt(i);
            childen.setEnabled(false);
        }
    }

    public static void showView(ViewGroup view, int time) {
        RotateAnimation rotateAnimation = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setStartOffset(time);//动画停留在播放完成的状态
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
        for (int i = 0; i < view.getChildCount(); i++) {
            View childen = view.getChildAt(i);
            childen.setEnabled(true);
        }
    }
}
