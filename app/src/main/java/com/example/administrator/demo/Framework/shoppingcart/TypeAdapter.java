package com.example.administrator.demo.Framework.shoppingcart;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo.Framework.materialdesign.recyclerview.ShopCartFragment;
import com.example.administrator.demo.R;

import java.util.ArrayList;

import static com.example.administrator.demo.R.id.count;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {
    private Context context;
    public int selectTypeId;
    public ShoppingCartActivity activity;
    public ArrayList<GoodsItem> dataList;
    private onClickListener listener;


    public interface onClickListener {
        void onClick(int position);
    }


    public TypeAdapter(ShoppingCartActivity activity, ArrayList<GoodsItem> dataList) {
        this.activity = activity;
        this.dataList = dataList;
    }

    public TypeAdapter(Context context, ArrayList<GoodsItem> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void OnClickListener(onClickListener listener) {
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GoodsItem item = dataList.get(position);

        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvCount, type;
        private GoodsItem item;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCount = (TextView) itemView.findViewById(R.id.tvCount);
            type = (TextView) itemView.findViewById(R.id.type);
            itemView.setOnClickListener(this);
        }

        public void bindData(GoodsItem item) {
            this.item = item;
            int count;
            type.setText(item.typeName);
            if (activity == null) {
                count = ShopCartFragment.getSelectedGroupCountByTypeId(item.typeId);
            } else {
                count = activity.getSelectedGroupCountByTypeId(item.typeId);
            }
            tvCount.setText(String.valueOf(count));
            if (count < 1) {
                tvCount.setVisibility(View.GONE);
            } else {
                tvCount.setVisibility(View.VISIBLE);
            }
            if (item.typeId == selectTypeId) {
                itemView.setBackgroundColor(Color.WHITE);
            } else {
                itemView.setBackgroundColor(Color.TRANSPARENT);
            }

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(item.typeId);
            } else {
                activity.onTypeClicked(item.typeId);
            }
        }
    }
}
