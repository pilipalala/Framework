package com.example.administrator.demo.Framework.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.demo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

/**
 * Created by Administrator on 2016/12/23.
 */
public class ImageLoaderViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    ImageLoader imageLoader;
    DisplayImageOptions options;

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_imageloader_viewpager, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv_imageloader_viewpager);
        imageLoader.displayImage(ImageLoaderConstants.IMAGES[position], iv, options);
        ((ViewPager)container).addView(view,0);
        return view;
    }

    public ImageLoaderViewPagerAdapter(Context context) {
        mContext = context;
        imageLoader = ImageLoader.getInstance();
        // 配置图片加载参数
        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)  // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_launcher)      // 设置图片加载或解码过程中发生错误显示的图片
                .resetViewBeforeLoading(true)               // 设置图片在下载前是否重置，复位
                .cacheOnDisc(true)                          // 设置下载的图片是否缓存在SD卡中
                .imageScaleType(ImageScaleType.EXACTLY)     // 设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)        // 设置图片的解码类型
                .displayer(new FadeInBitmapDisplayer(300))  // 设置图片渐变显示
                .build();
    }

    @Override
    public int getCount() {
        return ImageLoaderConstants.IMAGES.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
