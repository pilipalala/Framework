package com.example.administrator.demo.Framework.xutils3.annotation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo.R;
import com.jude.swipbackhelper.SwipeBackHelper;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2016/12/20.
 */
@ContentView(R.layout.fragment_demo)
public class DemoFragment extends Fragment {

    @ViewInject(R.id.btn_fragment)
    private Button button;
    @ViewInject(R.id.textView)
    private TextView textView;
    Context mContext;

    /*Fragment创建的时候调用*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        SwipeBackHelper.onCreate(getActivity());
        SwipeBackHelper.getCurrentPage(getActivity())//获取当前页面
                .setSwipeBackEnable(true);//设置是否可滑动
    }

    @Nullable
    @Override
    /*Fragment视图创建的时候调用*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return x.view().inject(this, inflater, container);
    }

    @Override
    /*当Activity创建好了 调用*/
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "点击", Toast.LENGTH_SHORT).show();
            }
        });
        textView.setText("我在Fragment中被初始化了");
    }


}
