package com.example.administrator.demo.Framework.guanggaotiao;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuangGaoTiaoActivity extends BaseActivity {

    @Bind(R.id.gg_viewpager)
    ViewPager ggViewpager;
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.ll_point)
    LinearLayout llPoint;
    private ArrayList<ImageView> imageViewList;
    // 图片资源ID
    private final int[] imageIds = {
            R.mipmap.a,
            R.mipmap.b,
            R.mipmap.c,
            R.mipmap.d,
            R.mipmap.e};
    // 图片标题集合
    private final String[] imageDescriptions = {
            "尚硅谷波河争霸赛！",
            "凝聚你我，放飞梦想！",
            "抱歉没座位了！",
            "7月就业名单全部曝光！",
            "平均起薪11345元"
    };
    private int prePostion = 0;


    /**
     * ViewPager的使用
     * 1、在布局文件中定义viewPager
     * 2、在代码中实例化ViewPager
     * 3、准备数据
     * 4、设置适配器（PagerAdapter）
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guang_gao_tiao);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        imageViewList = new ArrayList<ImageView>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);


        for (int i = 0; i < imageIds.length; i++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(imageIds[i]);
            //添加数据
            imageViewList.add(image);

            //添加点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_selector);
            if (i == 0) {
                point.setEnabled(true);//显示红色
            } else {
                point.setEnabled(false);//显示灰色
                params.leftMargin = 15;
            }
            point.setLayoutParams(params);
            llPoint.addView(point);
        }
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this, imageViewList);
        //设置适配器（PagerAdapter）
        ggViewpager.setAdapter(adapter);
        text.setText(imageDescriptions[prePostion]);
        /*设置viewPager页面监听*/
        ggViewpager.addOnPageChangeListener(new MyViewPagerListener());

    }

    private class MyViewPagerListener implements ViewPager.OnPageChangeListener {
        /**
         * 当页面滚动了的时候回调这个方法
         *
         * @param position             当前页面的位置
         * @param positionOffset       滑动页面的百分比
         * @param positionOffsetPixels 在屏幕上滑动的像素
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * 当页面被选中了的时候
         *
         * @param position 被选中页面的位置
         */
        @Override
        public void onPageSelected(int position) {
            //设置对应页面的文本信息
            text.setText(imageDescriptions[position%imageViewList.size()]);
            llPoint.getChildAt(position%imageViewList.size()).setEnabled(true);
            llPoint.getChildAt(prePostion).setEnabled(false);

            prePostion = position%imageViewList.size();
        }

        /**
         * 当页面滚动状态变化的时候回调
         * 静止-->滑动
         * 滑动-->静止
         * 静止-->拖拽
         *
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
