package com.example.administrator.demo.Framework.countdown;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountDownActivity extends BaseActivity {

    @Bind(R.id.btn_runnable)
    Button btnRunnable;
    @Bind(R.id.btn_countDownButton)
    CountDownTimerButton btnCountDownButton;
    @Bind(R.id.btn_countDownTimer)
    Button btnCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_runnable, R.id.btn_countDownButton, R.id.btn_countDownTimer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_runnable:
                startActivity(new Intent(CountDownActivity.this, CountDownRunnableActivity.class));
                break;
            case R.id.btn_countDownButton:
                Toast.makeText(CountDownActivity.this, "倒计时开始", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_countDownTimer:
                startActivity(new Intent(CountDownActivity.this, CountDownTimerActivity.class));
                break;
        }
    }
}
