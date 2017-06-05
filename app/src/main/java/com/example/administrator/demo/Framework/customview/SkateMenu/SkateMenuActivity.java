package com.example.administrator.demo.Framework.customview.SkateMenu;

import android.os.Bundle;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.ButterKnife;

public class SkateMenuActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_main);
        ButterKnife.bind(this);
    }
}
