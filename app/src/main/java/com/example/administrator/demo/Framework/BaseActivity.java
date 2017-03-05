package com.example.administrator.demo.Framework;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.demo.Framework.listener.PermissionListener;
import com.jude.swipbackhelper.SwipeBackHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
public class BaseActivity extends AppCompatActivity {
    private static PermissionListener mListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)//获取当前页面
                .setSwipeBackEnable(true)//设置是否可滑动
                .setSwipeEdge(200)//可滑动的范围。px。200表示为左边200px的屏幕
                .setSwipeEdgePercent(0.2f)//可滑动的范围。百分比。0.2表示为左边20%的屏幕
                .setSwipeSensitivity(0.5f)//对横向滑动手势的敏感程度。0为迟钝 1为敏感
                //.setScrimColor(Color.BLUE)//底层阴影颜色
                .setClosePercent(0.5f)//触发关闭Activity百分比
                .setSwipeRelateEnable(true)//是否与下一级activity联动(微信效果)。默认关
                .setSwipeRelateOffset(500)//activity联动时的偏移量。默认500px。
                //.setDisallowInterceptTouchEvent(true)//不抢占事件，默认关（事件将先由子View处理再由滑动关闭处理）
                /*.addListener(new SwipeListener() {
                    @Override
                    public void onScroll(float percent, int px) {//滑动的百分比与距离

                    }

                    @Override
                    public void onEdgeTouch() {//当开始滑动

                    }

                    @Override
                    public void onScrollToClose() {//当滑动关闭

                    }//滑动监听
                })*/;
    }

    protected static void requestRuntimePermission(String[] permissions, PermissionListener listener) {
        Activity topActivity = ActivityCollector.getTopActivity();
        if (topActivity == null) {
            return;
        }
        Log.e("onCreate", "onGranted: 2" );
        mListener = listener;
        //拒绝权限的集合
        ArrayList<String> permissionList = new ArrayList<String>();
        for (String permission : permissions) {
            Log.e("onCreate", "onGranted: 3" );
            Log.e("onCreate", "onGranted: 3" +permissions);
            Log.e("onCreate", "onGranted: 3" +permission);
            if (ContextCompat.checkSelfPermission(topActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                Log.e("onCreate", "onGranted: 4" );
                permissionList.add(permission);
            }
        }
        if (!permissionList.isEmpty()) {
            Log.e("onCreate", "onGranted: 5" );
            Log.e("onCreate", "onGranted: 5"+permissionList.size() );
            Log.e("onCreate", "onGranted: 5"+permissionList);
            ActivityCompat.requestPermissions(topActivity, permissionList.toArray(new String[permissionList.size()]), 1);
            Log.e("onCreate", "onGranted: 15" );
        } else {
            Log.e("onCreate", "onGranted: 6" );
            mListener.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    Log.e("onCreate", "onGranted: 7" );
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        Log.e("onCreate", "onGranted: 8" );
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            Log.e("onCreate", "onGranted: 9" );
                            deniedPermissions.add(permission);
                        }
                    }
                    if (deniedPermissions.isEmpty()) {
                        Log.e("onCreate", "onGranted: 11" );
                        mListener.onGranted();
                    } else {
                        Log.e("onCreate", "onGranted: 21" );
                        mListener.onDenied(deniedPermissions);
                    }
                }
                break;
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
        SwipeBackHelper.onDestroy(this);
    }
}
