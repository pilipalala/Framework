package com.example.administrator.demo.Framework.tablayout.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo.Framework.materialdesign.recyclerview.PaletteActivity;
import com.example.administrator.demo.Framework.materialdesign.recyclerview.RecyclerViewDetailActivity;
import com.example.administrator.demo.Framework.materialdesign.recyclerview.XiTuActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/3.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Context mContext;
    private final int num;

    public MyAdapter(Context mContext, int num) {
        this.mContext = mContext;
        this.num = num;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycleview_tablayout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.llDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position % 3 == 0) {
                    mContext.startActivity(new Intent(mContext, RecyclerViewDetailActivity.class));
                } else if (position % 3 == 1) {
                    mContext.startActivity(new Intent(mContext, XiTuActivity.class));
                } else if (position % 3 == 2) {
                    mContext.startActivity(new Intent(mContext, PaletteActivity.class));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return num;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_pullmorerecycle)
        ImageView ivPullmorerecycle;
        @Bind(R.id.tv_pullmorerecycle_title)
        TextView tvPullmorerecycleTitle;
        @Bind(R.id.ll_detail)
        LinearLayout llDetail;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
