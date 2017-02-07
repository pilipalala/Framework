package com.example.administrator.demo.Framework.banner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.MyApplication;
import com.example.administrator.demo.Framework.banner.GlideImageLoader;
import com.example.administrator.demo.Framework.banner.SampleAdapter;
import com.example.administrator.demo.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BannerMainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {
    static final int REFRESH_COMPLETE = 0X1112;
    SwipeRefreshLayout mSwipeLayout;
    ListView listView;
    Banner banner;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    String[] urls = getResources().getStringArray(R.array.url);
                    List list = Arrays.asList(urls);
                    List arrayList = new ArrayList(list);
                    banner.update(arrayList);
                    mSwipeLayout.setRefreshing(false);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_main);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        /*设置下拉刷新监听*/
        mSwipeLayout.setOnRefreshListener(this);

        listView = (ListView) findViewById(R.id.list);

        /*加载Banner*/
        View header = LayoutInflater.from(this).inflate(R.layout.header, null);
        banner = (Banner) header.findViewById(R.id.banner);
        /*设置高和宽*/
        banner.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, MyApplication.H / 4));
        /*Banner以头的方式添加到ListView中*/
        listView.addHeaderView(banner);

        /*集合数据*/
        String[] data = getResources().getStringArray(R.array.demo_list);
        /*设置LIstView的适配器*/
        listView.setAdapter(new SampleAdapter(this, data));
        listView.setOnItemClickListener(this);
        //简单使用
        banner.setImages(MyApplication.images)
                .setImageLoader(new GlideImageLoader())
                .setDelayTime(1000)
                .start();
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(BannerMainActivity.this, position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }


    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
                startActivity(new Intent(this, BannerAnimationActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, BannerStyleActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, IndicatorPositionActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, CustomBannerActivity.class));
                break;
        }
    }

}
