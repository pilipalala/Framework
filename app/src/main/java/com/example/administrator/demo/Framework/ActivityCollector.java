package com.example.administrator.demo.Framework;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 */

public class ActivityCollector {
    public static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static Activity getTopActivity() {
        if (activityList.isEmpty()) {
            return null;
        } else {
            return activityList.get(activityList.size() - 1);
        }
    }

    public static void clearAll() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }
}
