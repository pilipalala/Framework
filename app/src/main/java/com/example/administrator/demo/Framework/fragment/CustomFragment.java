package com.example.administrator.demo.Framework.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.demo.Framework.BaseFragment;
import com.example.administrator.demo.Framework.guanggaotiao.GuangGaoTiaoActivity;
import com.example.administrator.demo.Framework.youkumenu.YouKuMenuActivity;
import com.example.administrator.demo.Main.utils.DataUtil;
import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2016/12/13.
 */
public class CustomFragment extends BaseFragment {

    private static final String TAG = "CustomFragment";
    private ListView mListView;
    @Override
    protected View initView() {
        Log.e(TAG,"自定义控件页面初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        mListView = (ListView) view.findViewById(R.id.listView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getActivity(), YouKuMenuActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), GuangGaoTiaoActivity.class));
                        break;
                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_expandable_list_item_1, DataUtil.CUSTOM_DATA);
        mListView.setAdapter(adapter);
        Log.e(TAG, "自定义控件数据初始化了...");

    }
}
