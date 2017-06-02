package com.example.administrator.demo.Framework.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseFragment;
import com.example.administrator.demo.Framework.DataUtil;
import com.example.administrator.demo.Framework.countdown.CountDownActivity;
import com.example.administrator.demo.Framework.customview.CustomViewMainActivity;
import com.example.administrator.demo.Framework.customview.QuickIndexActivity;
import com.example.administrator.demo.Framework.googlemap.MapsActivity;
import com.example.administrator.demo.Framework.materialdesign.drawerlayout.DrawerLayoutMainActivity;
import com.example.administrator.demo.Framework.materialdesign.recyclerview.BottomSheetActivity;
import com.example.administrator.demo.Framework.materialdesign.recyclerview.RecyclerViewActivity;
import com.example.administrator.demo.Framework.materialdesign.recyclerview.StyleActivity;
import com.example.administrator.demo.Framework.materialdesign.toolbar.ToolBarActivity;
import com.example.administrator.demo.Framework.materialdesign.translucentsystembar.TranslucentSystemBarActivity;
import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2016/12/13.
 */
public class OtherFragment extends BaseFragment {

    private TextView textView;
    private static final String TAG = "CustomFragment";
    private ListView mListView;
    private String[] activity = {DrawerLayoutMainActivity.class.getSimpleName()};


    @Override
    protected View initView() {
        Log.e(TAG, "其他页面初始化了...");
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_common_frame, null);
        mListView = (ListView) view.findViewById(R.id.listView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getActivity(), DrawerLayoutMainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), TranslucentSystemBarActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), ToolBarActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), RecyclerViewActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), MapsActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), StyleActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(getActivity(), BottomSheetActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(getActivity(), CountDownActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(getActivity(), CustomViewMainActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(getActivity(), QuickIndexActivity.class));
                        break;

                }
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        /*DrawerLayoutDemo*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_expandable_list_item_1, DataUtil.OTHER_DATA);
        mListView.setAdapter(adapter);
        Log.e(TAG, "其他数据初始化了...");
        super.initData();


    }
}
