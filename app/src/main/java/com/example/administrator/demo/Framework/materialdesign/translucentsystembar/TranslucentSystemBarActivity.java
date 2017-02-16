package com.example.administrator.demo.Framework.materialdesign.translucentsystembar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TranslucentSystemBarActivity extends BaseActivity {


    @Bind(R.id.ImageTranslucentBar)
    Button ImageTranslucentBar;
    @Bind(R.id.ColorTranslucentBar)
    Button ColorTranslucentBar;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent_system_bar);
        ButterKnife.bind(this);
        tvTitle.setText("沉浸式通知栏");
    }

    @OnClick({R.id.ImageTranslucentBar, R.id.ColorTranslucentBar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ImageTranslucentBar:
                startActivity(new Intent(this, ImageTranslucentBarActivity.class));
                break;
            case R.id.ColorTranslucentBar:
                startActivity(new Intent(this, ColorTranslucentBarActivity.class));
                break;
        }
    }
}
