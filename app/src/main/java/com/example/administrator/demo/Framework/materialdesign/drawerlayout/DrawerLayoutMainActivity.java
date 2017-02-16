package com.example.administrator.demo.Framework.materialdesign.drawerlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

public class DrawerLayoutMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_main);
    }
    public void doclick(View v){
        Intent intent;
        switch (v.getId()) {
            case R.id.drawer_layout_simple:
                intent = new Intent(this, DrawerLayoutDemo.class);
                startActivity(intent);
                break;
            case R.id.drawer_layout_below:
                intent = new Intent(this, DrawerLayout_BelowToolbarActivity.class);
                startActivity(intent);
                break;
            case R.id.drawer_layout_layout:
                intent = new Intent(this, DrawerLayout_OtherActivity.class);
                startActivity(intent);
                break;
        }
    }
}
