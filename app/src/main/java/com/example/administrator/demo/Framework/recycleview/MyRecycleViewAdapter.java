package com.example.administrator.demo.Framework.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demo.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {


    private final Context context;
    private onItemLintener onItemLintener;
    private List<String> datas;

    /*点击RecycleView的监听器*/
    public interface onItemLintener {
        /**
         * 当RecycleView被点击时候回调
         *
         * @param view 点击的item视图
         * @param data 点击得到的数据
         */
        public void onItemClick(View view, String data);

    }

    public MyRecycleViewAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    /*相当于ListView中的创建View和ViewHolder*/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycleview, parent, false);
        return new MyViewHolder(view);
    }

    /*数据和View绑定*/
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String data = datas.get(position);
        holder.tvItemRecycleView.setText(data);
    }

    /**
     * @param onItemLintener 设置监听器
     */
    public void setOnItemLintener(onItemLintener onItemLintener) {
        this.onItemLintener = onItemLintener;
    }

    /**
     * 添加数据
     * @param position
     * @param data
     */
    public void addData(int position, String data) {
        datas.add(position,data);
        /*刷新适配器*/
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        datas.remove(position);
        /*刷新数据*/
        notifyItemRemoved(position);

    }
    /*总条数*/
    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_icon_recycleView)
        ImageView ivIconRecycleView;
        @Bind(R.id.tv_item_recycleView)
        TextView tvItemRecycleView;

        //        private ImageView ivIconRecycleView;
//        private TextView tvItemRecycleView;
        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemLintener != null) {
                        onItemLintener.onItemClick(view, datas.get(getLayoutPosition()));
                    }
                }
            });
//            ivIconRecycleView = (ImageView) view.findViewById(R.id.iv_icon_recycleView);
//            tvItemRecycleView = (TextView) view.findViewById(R.id.tv_item_recycleView);

        }
    }


}
