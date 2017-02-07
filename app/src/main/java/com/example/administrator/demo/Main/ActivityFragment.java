package com.example.administrator.demo.Main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2016/9/3.
 */
public class ActivityFragment extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_main);
    }
}
