package com.example.administrator.demo.Framework.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.demo.Framework.BaseFragment;
import com.example.administrator.demo.Framework.banner.activity.BannerMainActivity;
import com.example.administrator.demo.Framework.eventbus.EventBusActivity;
import com.example.administrator.demo.Framework.fastjson.FastJsonActivity;
import com.example.administrator.demo.Framework.fresco.activity.FrescoMainActivity;
import com.example.administrator.demo.Framework.glide.activity.GlideMainActivity;
import com.example.administrator.demo.Framework.imageloader.ImageLoaderActivity;
import com.example.administrator.demo.Framework.json.activity.GsonActivity;
import com.example.administrator.demo.Framework.json.activity.NativeJsonPraseActivity;
import com.example.administrator.demo.Framework.okhttp.activity.OKHttpActivity;
import com.example.administrator.demo.Framework.picasso.activity.PicassoMainActivity;
import com.example.administrator.demo.Framework.pulltorefresh.PullToRefreshActivity;
import com.example.administrator.demo.Framework.recycleview.RecycleViewActivity;
import com.example.administrator.demo.Framework.tablayout.activity.TabLayoutMainActivity;
import com.example.administrator.demo.Framework.xutils3.XUtils3MainActivity;
import com.example.administrator.demo.Main.utils.DataUtil;
import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2016/12/13.
 */
public class CommonFrameFragment extends BaseFragment {
    private ListView mListView;
    private static final String TAG = "CustomFragment";

    @Override
    protected View initView() {
        Log.e(TAG, "常用框架页面初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        mListView = (ListView) view.findViewById(R.id.listView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data = DataUtil.COMMON_DATA[i];
                if (data.toLowerCase().equals("okhttp")) {
                    startActivity(new Intent(getActivity(), OKHttpActivity.class));
                } else if (data.toLowerCase().equals("nativejsonparse")) {
                    startActivity(new Intent(getActivity(), NativeJsonPraseActivity.class));
                }else if (data.toLowerCase().equals("gson")) {
                    startActivity(new Intent(getActivity(), GsonActivity.class));
                }else if (data.toLowerCase().equals("fastjson")) {
                    startActivity(new Intent(getActivity(), FastJsonActivity.class));
                }else if (data.toLowerCase().equals("xutils3")) {
                    startActivity(new Intent(getActivity(), XUtils3MainActivity.class));
                }else if (data.toLowerCase().equals("eventbus")) {
                    startActivity(new Intent(getActivity(), EventBusActivity.class));
                }else if (data.toLowerCase().equals("imageloader")) {
                    startActivity(new Intent(getActivity(), ImageLoaderActivity.class));
                }else if (data.toLowerCase().equals("pulltorefresh")) {
                    startActivity(new Intent(getActivity(), PullToRefreshActivity.class));
                }else if (data.toLowerCase().equals("recycleview")) {
                    startActivity(new Intent(getActivity(), RecycleViewActivity.class));
                }else if (data.toLowerCase().equals("banner")) {
                    startActivity(new Intent(getActivity(), BannerMainActivity.class));
                }else if (data.toLowerCase().equals("tablayout")) {
                    startActivity(new Intent(getActivity(), TabLayoutMainActivity.class));
                }else if (data.toLowerCase().equals("glide")) {
                    startActivity(new Intent(getActivity(), GlideMainActivity.class));
                }else if (data.toLowerCase().equals("picasso")) {
                    startActivity(new Intent(getActivity(), PicassoMainActivity.class));
                }else if (data.toLowerCase().equals("fresco")) {
                    startActivity(new Intent(getActivity(), FrescoMainActivity.class));
                }
            }
        });

        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_expandable_list_item_1, DataUtil.COMMON_DATA);
        mListView.setAdapter(adapter);
        Log.e(TAG, "常用框架数据初始化了...");

    }
}
