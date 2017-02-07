package com.example.administrator.demo.Main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2016/8/12.
 */
public class Activity1 extends Activity {
    private FrameLayout frameLayout;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayoutId);
       // recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);






    }
}
