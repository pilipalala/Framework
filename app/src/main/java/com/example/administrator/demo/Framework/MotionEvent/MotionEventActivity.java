package com.example.administrator.demo.Framework.MotionEvent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MotionEventActivity extends BaseActivity {

    @Bind(R.id.btn_main_test1)
    Button btnMainTest1;
    @Bind(R.id.btn_main_test2)
    Button btnMainTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_main_test1, R.id.btn_main_test2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_main_test1:
                startActivity(new Intent(this, MotionEventTestActivity.class));
                break;
            case R.id.btn_main_test2:
                startActivity(new Intent(this, KeyEventTestActivity.class));
                break;
        }
    }
}
