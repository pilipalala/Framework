package com.example.administrator.demo.Main.utils;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyj on 2016/10/8.
 */
public class CycleViewPager extends Fragment implements OnPageChangeListener {
    private List<ImageView> imageViews = new ArrayList<ImageView>();
    private ImageView[] indicators;
    private FrameLayout viewPagerFragmentLayout;
    private LinearLayout indicatorLayout; // 指示器
    private BaseViewPager viewPager;
    private ImageCycleViewListener mImageCycleViewListener;
    private List<String> infos;
    private boolean isCycle = false;//是否循环
    private boolean isWheel = false;//是否轮播
    private ViewPagerAdapter adapter;
    private int currentPosition = 0;//轮播当前位置

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_cycle_viewpager_contet, null);
        viewPager = (BaseViewPager) view.findViewById(R.id.viewPager);
        indicatorLayout = (LinearLayout) view
                .findViewById(R.id.layout_viewpager_indicator);

        viewPagerFragmentLayout = (FrameLayout) view
                .findViewById(R.id.layout_viewager_content);
        return view;
    }


    public void setData(List<ImageView> views, List<String> list, ImageCycleViewListener listener) {
        setData(views, list, listener, 0);
    }

    public void setData(List<ImageView> views, List<String> list, ImageCycleViewListener listener, int showPosition) {
        mImageCycleViewListener = listener;
        infos = list;
        this.imageViews.clear();

        if (views.size() == 0) {
            viewPagerFragmentLayout.setVisibility(View.GONE);
            return;
        }
        for (ImageView item : views) {
            this.imageViews.add(item);
        }
        int ivSize = views.size();

        indicators = new ImageView[ivSize];
        if (isCycle)
            indicators = new ImageView[ivSize - 2];
        indicatorLayout.removeAllViews();
        for (int i = 0; i < indicators.length; i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_cycle_viewpager_indicator, null);
            indicators[i] = (ImageView) view.findViewById(R.id.image_indicator);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 5, 0);
            indicators[i].setLayoutParams(params);
            viewPagerFragmentLayout.addView(view);
        }
        adapter = new ViewPagerAdapter();
    }



    /**
     * ViewPager 详解
     * http://blog.csdn.net/harvic880925/article/details/38487149
     */
    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        /**
         * 页面适配器 返回对应的view
         *
         * @param container
         * @param position
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final ImageView v = imageViews.get(position);
            if (mImageCycleViewListener != null) {
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mImageCycleViewListener.onImageClick(infos.get(currentPosition - 1), currentPosition, v);
                    }
                });
            }
            v.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(v);
            return v;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    /**
     * 轮播控件的监听事件
     */
    public static interface ImageCycleViewListener {
        /**
         * 单击图片事件
         *
         * @param info
         * @param postion
         * @param imageView
         */
        public void onImageClick(String info, int postion, View imageView);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
