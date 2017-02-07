package com.example.administrator.demo.Framework.recycleview;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecycleViewActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.btn_add)
    Button btnAdd;
    @Bind(R.id.btn_select)
    Button btnSelect;
    @Bind(R.id.btn_list)
    Button btnList;
    @Bind(R.id.btn_grid)
    Button btnGrid;
    @Bind(R.id.btn_flow)
    Button btnFlow;
    @Bind(R.id.recycleView)
    RecyclerView recycleView;
    private List<String> datas;
    private MyRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);
        initView();
        /*设置RecycleView的适配器*/
        adapter = new MyRecycleViewAdapter(this, datas);
        recycleView.setAdapter(adapter);
        /*设置layoutManager*/
        recycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        /*添加RecycleView的分割线*/
        recycleView.addItemDecoration(new DividerListItemDecoration(this,LinearLayoutManager.VERTICAL));

        /*设置监听器*/
        adapter.setOnItemLintener(new MyRecycleViewAdapter.onItemLintener() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(RecycleViewActivity.this, "data=="+data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        tvTitle.setText("RecycleView");
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("Content_" + i);
        }
    }

    @OnClick({R.id.btn_add, R.id.btn_select, R.id.btn_list, R.id.btn_grid, R.id.btn_flow})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_add:
                adapter.addData(0,"这是条新数据");
                recycleView.scrollToPosition(0);
                break;
            case R.id.btn_select:
                adapter.removeData(0);
                break;
            /*设置list类型效果*/
            case R.id.btn_list:
                recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                recycleView.scrollToPosition(50);
                break;
            /*设置Grid类型效果*/
            case R.id.btn_grid:
                recycleView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
                break;
            /*设置瀑布流类型效果*/
            case R.id.btn_flow:
                recycleView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
    }
}
