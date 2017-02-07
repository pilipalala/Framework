package com.example.administrator.demo.Main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public class SwipeRefresh extends Activity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private List<String> data;
    private ArrayAdapter<String> adapter;
    private int j = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        data = new ArrayList<String>();
        listView = (ListView) findViewById(R.id.listViewId);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SwipeRefresh.this,data.get(i),Toast.LENGTH_SHORT).show();
            }
        });

        /*----------------------刷新--------------------------------------*/
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh_layout);
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.darker_gray,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);// 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色

        swipeRefreshLayout.setDistanceToTriggerSync(300);// 设置手指在屏幕下拉多少距离会触发下拉刷新

        swipeRefreshLayout.setProgressBackgroundColor(android.R.color.holo_blue_light);// 设定下拉圆圈的背景

        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);//设置圆圈大小

        //监听器SwipeRefreshLayout.OnRefreshListener中的方法，当下拉刷新后触发
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        data.add("SwipeRefreshLayout" + (j++));
                        adapter.notifyDataSetChanged();
                        //Toast.makeText(SwipeRefresh.this, data.size() + "", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);//停止刷新
                    }
                }, 1000);
            }
        });
    }
}
