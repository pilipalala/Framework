package com.example.administrator.demo.Framework.MotionEvent;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MotionEventTestActivity extends BaseActivity {

    private static final String TAG = "WANGYUJIE";
    @Bind(R.id.miv)
    MyImageView miv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event_test);
        ButterKnife.bind(this);
        miv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, "MyImageView dispatchTouchEvent: " + event.getAction());
                return false;

            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "Activity dispatchTouchEvent: " + ev.getAction());
        return super.dispatchTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "Activity onTouchEvent: " + event.getAction());
        return super.onTouchEvent(event);

    }
}
