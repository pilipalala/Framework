package com.example.administrator.demo.Framework;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by wangyujie
 * Date 2017/6/8
 * Time 21:48
 * TODO
 */

public class ToastUtils {

    public static Activity activity = ActivityCollector.getTopActivity();
    public static void show(String info) {
        if (TextUtils.isEmpty(info)) {
            return;
        }
        Toast.makeText(activity,info,Toast.LENGTH_LONG).show();
    }
    public static void show(int info) {
        if (TextUtils.isEmpty(String.valueOf(info))) {
            return;
        }
        Toast.makeText(activity,String.valueOf(info),Toast.LENGTH_LONG).show();
    }

}
