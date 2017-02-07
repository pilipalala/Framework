package com.example.administrator.demo.Framework.imageloader;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/22.
 */
public class ImageLoaderListViewAdapter extends BaseAdapter {
    private Context context;
    private ImageLoader imageLoader;
    DisplayImageOptions options;

    public ImageLoaderListViewAdapter(Context context) {
        this.context = context;
        // 获取ImageLoader实例
        imageLoader = ImageLoader.getInstance();

        options = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.ic_launcher)          // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)  // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_launcher)       // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)                          // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(20))  // 设置成圆角图片
                .build();                                   // 创建配置过得DisplayImageOption对象
    }

    @Override
    public int getCount() {
        return ImageLoaderConstants.IMAGES.length;
    }

    @Override
    public Object getItem(int i) {
        return ImageLoaderConstants.IMAGES[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        /*1、获取或创建viewHolder*/
        ViewHolder holder;
        if (view == null) {
            view = LinearLayout.inflate(context, R.layout.item_imageloader_list, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        /*2、获取当前item数据*/

        /*3、显示数据*/

        holder.textView.setText("item" +(i+1));
        imageLoader.displayImage(ImageLoaderConstants.IMAGES[i], holder.imageView, options);

        return view;
    }

    class ViewHolder {
        @Bind(R.id.iv_imageloader_listview)
        ImageView imageView;
        @Bind(R.id.tv_imageloader_title)
        TextView textView;
        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }
}
