package com.example.administrator.demo.Framework.glide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/5.
 */
public class GlideRecycleViewAdapter extends RecyclerView.Adapter<GlideRecycleViewAdapter.MyViewHolder> {
    private final Context mContext;
    private final String[] mDatas;

    public GlideRecycleViewAdapter(Context mContext, String[] mDatas) {
        super();
        this.mContext = mContext;
        this.mDatas = mDatas;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(mContext).inflate(R.layout.glide_recycleview_adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        /*显示图片*/
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, mContext.getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, mContext.getResources().getDisplayMetrics());

        Glide.with(mContext)
                .load(mDatas[position])
                .placeholder(R.mipmap.ic_launcher) //占位图
                .error(R.mipmap.ic_launcher)  //出错的占位图
                .override(width, height) //图片显示的分辨率 ，像素值 可以转化为DP再设置
                .animate(R.animator.glide_anim)
                .centerCrop()
                .fitCenter()
                .into(holder.ivImageview);
    }


    @Override
    public int getItemCount() {
        return mDatas.length;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_imageview)
        ImageView ivImageview;
        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
