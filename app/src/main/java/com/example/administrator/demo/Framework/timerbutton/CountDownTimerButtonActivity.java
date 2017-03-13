package com.example.administrator.demo.Framework.timerbutton;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountDownTimerButtonActivity extends BaseActivity {

    @Bind(R.id.bt_runnable)
    Button btRunnable;
    @Bind(R.id.bt_custonButton)
    Button btCustonButton;
    @Bind(R.id.bt_countDownTimer)
    Button btCountDownTimer;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_timer_button);
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.bt_runnable, R.id.bt_custonButton, R.id.bt_countDownTimer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_runnable:
                break;
            case R.id.bt_custonButton:
                break;
            case R.id.bt_countDownTimer:
                break;
        }
    }
}
