package com.example.administrator.demo.Framework.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.administrator.demo.R;

/**
 * Created by wangyujie
 * Date 2017/6/29
 * Time 0:12
 * TODO
 */

public class MyDialog extends Dialog {


    private LinearLayout linearLayout;

    public MyDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        linearLayout = (LinearLayout) findViewById(R.id.main);
    }

    @Override
    public void show() {
        super.show();
        animation(700);
    }

    public void animation(int mDuration) {

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                //定义view基于scaleX的缩放过程
                ObjectAnimator.ofFloat(linearLayout, "alpha", 1, 0, 0),//
                ObjectAnimator.ofFloat(linearLayout, "scaleX", 1, 0.3f, 0),//
                ObjectAnimator.ofFloat(linearLayout, "scaleY", 1, 0.3f, 0));//
        animatorSet.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();

    }
}
