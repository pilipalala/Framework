package com.example.administrator.demo.Framework.youkumenu;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class YouKuMenuActivity extends BaseActivity {

    @Bind(R.id.level3)
    RelativeLayout level3;
    @Bind(R.id.icon_menu)
    ImageView iconMenu;
    @Bind(R.id.level2)
    RelativeLayout level2;
    @Bind(R.id.icon_home)
    ImageView iconHome;
    @Bind(R.id.level1)
    RelativeLayout level1;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.image)
    ImageView image;

    /**
     * 是否显示第一个圆环
     * true 显示
     * false 隐藏
     */
    private boolean isShowLevel1 = true;
    /**
     * 是否显示第二个圆环
     * true 显示
     * false 隐藏
     */
    private boolean isShowLevel2 = true;
    /**
     * 是否显示第三个圆环
     * true 显示
     * false 隐藏
     */
    private boolean isShowLevel3 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_ku_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.icon_menu, R.id.icon_home, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(YouKuMenuActivity.this, "属性动画", Toast.LENGTH_SHORT).show();
                /*ObjectAnimator.ofFloat(image, "rotationX", 0, 360).setDuration(1000).start();
                ObjectAnimator.ofFloat(image, "rotationY", 0, 360).setDuration(1000).start();*/

                /*PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("translationX", 0, 100);
                PropertyValuesHolder holder4 = PropertyValuesHolder.ofFloat("translationY", 0, 100);
                PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 0, 1);
                PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("scaleY", 0, 1);
                ObjectAnimator.ofPropertyValuesHolder(image,  holder2).setDuration(2000).start();*/

                /*ObjectAnimator animator1 = ObjectAnimator.ofFloat(image, "translationX", 0, 100);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(image, "alpha", 0, 1);
                AnimatorSet animatorSet = new AnimatorSet();
                *//********按顺序播放*****//*
                animatorSet.playSequentially(animator1, animator2);



                animatorSet.setDuration(2000);
                animatorSet.start();*/

                ValueAnimator animator = ValueAnimator.ofObject(new TypeEvaluator<PointF>() {

                    @Override
                    public PointF evaluate(float fraction, PointF startValue,
                                           PointF endValue) {

                        float x = (endValue.x - startValue.x) * fraction;
                        float y = (endValue.y - startValue.x) * fraction;
                        button.setX(x);
                        button.setY(y);
                        return null;
                    }
                }, new PointF(1, 1), new PointF(300, 300));
                animator.setDuration(5000);
                animator.start();


                break;
            case R.id.icon_menu:
                if (isShowLevel3) {
                    //隐藏
                    Tools.hideView(level3);
                    isShowLevel3 = false;
//                    level3.setVisibility(View.GONE);
                } else {
                    //显示
                    Tools.showView(level3);
                    isShowLevel3 = true;
//                    level3.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.icon_home:

                if (isShowLevel2) {
                    //隐藏
                    Tools.hideView(level2);
                    isShowLevel2 = false;
//                    level2.setVisibility(View.GONE);
                    if (isShowLevel3) {
                        //隐藏
                        Tools.hideView(level3, 700);
                        isShowLevel3 = false;
//                        level3.setVisibility(View.GONE);
                    }
                } else {
                    //显示
                    Tools.showView(level2);
                    isShowLevel2 = true;
//                    level2.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            if (isShowLevel1) {
                /*隐藏一级*/
                Tools.hideView(level1);
//                level1.setVisibility(View.GONE);
                isShowLevel1 = false;
                if (isShowLevel2) {
                    /*隐藏二级*/
                    Tools.hideView(level2, 300);
//                    level2.setVisibility(View.GONE);
                    isShowLevel2 = false;
                    if (isShowLevel3) {
                        /*隐藏三级*/
                        Tools.hideView(level3, 600);
//                        level3.setVisibility(View.GONE);
                        isShowLevel3 = false;
                    }
                }

            } else {
                Tools.showView(level1);
//                level1.setVisibility(View.VISIBLE);
                isShowLevel1 = true;
                Tools.showView(level2, 500);
//                level2.setVisibility(View.VISIBLE);
                isShowLevel2 = true;
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);

    }
}
