package com.example.administrator.demo.Framework.xutils3.annotation;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.jude.swipbackhelper.SwipeBackHelper;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_fragment_xutils3)
public class FragmentXUtils3Activity extends FragmentActivity {

    @ViewInject(R.id.tv_title)
    private TextView title;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_xutils3);
        x.view().inject(this);
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)//获取当前页面
                .setSwipeBackEnable(true);//设置是否可滑动
        title.setText("在Fragment中使用");
        /*1、获得FragmentManager*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        /*2、开启事物*/
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        /*3、替换Fragment*/
        transaction.replace(R.id.xutils3_fragment, new DemoFragment());
        /*4、提交*/
        transaction.commit();
    }
}
