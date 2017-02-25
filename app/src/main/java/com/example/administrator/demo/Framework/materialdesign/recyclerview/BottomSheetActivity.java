package com.example.administrator.demo.Framework.materialdesign.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomSheetActivity extends BaseActivity {


    BottomSheetBehavior behavior;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.button0)
    Button button0;
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.bottom_sheet)
    NestedScrollView bottomSheet;

    private String TAG = BottomSheetActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            /**
             * behavior_hideable对应代码 behavior.setHideable(false);
             behavior_peekHeight对应代码 behavior.setPeekHeight(50);
             * */
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                /*bottomSheet状态的改变*/
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    Log.e(TAG, "完全展开的状态: ");
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    Log.e(TAG, "隐藏状态: ");
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    Log.e(TAG, "折叠关闭状态: ");
                } else if (newState == BottomSheetBehavior.STATE_SETTLING) {
                    Log.e(TAG, "拖拽松开之后到达终点位置（collapsed or expanded）前的状态: ");
                } else if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    Log.e(TAG, "被拖拽状态:");
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
                /*这里是拖拽的回调，根据slideOffset可以做些动画*/


            }
        });

    }

    @OnClick({R.id.button0, R.id.button1, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                break;
            case R.id.button1:
                final BottomSheetDialog dialog = new BottomSheetDialog(this);
                View inflate = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
                dialog.setContentView(inflate);
                Button bsdButton = (Button) inflate.findViewById(R.id.bsd_button);
                TextView textView = (TextView) inflate.findViewById(R.id.bsd_text);

                textView.setText("BottomSheetDialog");
                bsdButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(BottomSheetActivity.this, RecyclerViewDetailActivity.class));
                        dialog.dismiss();
                    }
                });
                dialog.show();
                dialog.setCanceledOnTouchOutside(false);
                break;
            case R.id.button2:
                new FullSheetDialogFragment().show(getSupportFragmentManager(),"dialog");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float X_UP = 0, Y_UP = 0, X_DOWN = 0, Y_DOWN = 0;
        int touchEvent = event.getAction();
        switch (touchEvent) {
            case MotionEvent.ACTION_POINTER_DOWN:
                display("动作按下");
                X_DOWN = event.getX();
                Log.e(TAG, "X_DOWN: " + X_DOWN);
                Log.e(TAG, "Y_DOWN: " + Y_DOWN);
                Y_DOWN = event.getY();
                break;
            case MotionEvent.ACTION_POINTER_UP:
                display("动作按上");
                Log.e(TAG, "X_UP: " + X_UP);
                Log.e(TAG, "Y_UP: " + Y_UP);
                X_UP = event.getX();
                Y_UP = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
//                display("动作滑动");
                break;
            default:
                break;
        }
        if (X_DOWN > X_UP) {
//            display("向左滑动");
        }
        if (X_DOWN < X_UP) {
//            display("向左滑动");
        }
        if (Y_DOWN > Y_UP) {
//            display("向下滑动");
        }
        if (Y_DOWN < Y_UP) {
//            display("向上滑动");
        }
        return super.onTouchEvent(event);

    }

    public void display(String str) {
        Toast toast = Toast.makeText(this, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 450);
        toast.show();
    }
}
