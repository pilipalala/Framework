package com.example.administrator.demo.Framework.picasso.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.picasso.PicassoConstants;
import com.example.administrator.demo.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/8.
 */
public class PicassoListViewAdapter extends BaseAdapter {
    private final Context context;

    public PicassoListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return PicassoConstants.IMAGES.length;
    }

    @Override
    public Object getItem(int i) {
        return PicassoConstants.IMAGES[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PicassoViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_picasso_listview, null);
            holder = new PicassoViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (PicassoViewHolder) view.getTag();
        }
        /*显示名称*/
        holder.tvPicasso.setText("item" + i);
        /*显示图片*/
        Picasso.with(context)
                .load(PicassoConstants.IMAGES[i])
                .placeholder(R.mipmap.atguigu_logo)
                .error(R.mipmap.atguigu_logo)
                .into(holder.ivPicasso);
        return view;
    }

    static class PicassoViewHolder {
        @Bind(R.id.iv_picasso)
        ImageView ivPicasso;
        @Bind(R.id.tv_picasso)
        TextView tvPicasso;

        PicassoViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
