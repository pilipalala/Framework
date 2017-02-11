package com.example.administrator.demo.Framework.guanggaotiao;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/11.
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private ArrayList<ImageView> imageViewList;
    private Context context;

    public MyViewPagerAdapter(Context context, ArrayList<ImageView> imageViewList) {
        this.context = context;
        this.imageViewList = imageViewList;
    }

    /**
     * 相当于getView方法
     *
     * @param container viewPager自身
     * @param position  当前实例化页面的位置
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imageViewList.get(position);
        container.addView(imageView); //添加到ViewPager中
        return imageView;
    }


    @Override
    public int getCount() {
        return imageViewList == null ? 0 : imageViewList.size();
    }

    /**
     * 比较view和object 是否是同一个示例
     *
     * @param view   页面
     * @param object instantiateItem方法返回的结果
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 释放资源
     *
     * @param container viewPager
     * @param position 要释放的位置
     * @param object 要释放的页面
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }

}
