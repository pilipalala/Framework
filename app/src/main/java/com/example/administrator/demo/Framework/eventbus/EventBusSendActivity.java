package com.example.administrator.demo.Framework.eventbus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusSendActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_title, tv_result;
    private Button btn_send_main, btn_send_sticky;
    private boolean isRegist = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_send);
        initView();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("EventBus发送界面");
        btn_send_main = (Button) findViewById(R.id.btn_eventbus_send_main);
        btn_send_sticky = (Button) findViewById(R.id.btn_eventbus_send_sticky);
        tv_result = (TextView) findViewById(R.id.tv_eventbus_send_result);
        btn_send_main.setOnClickListener(this);
        btn_send_sticky.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /*主线程发送数据按钮点击事件*/
            case R.id.btn_eventbus_send_main:
                /*4.发送消息*/
                EventBus.getDefault().post(new MessageEvent("主线程发过来的数据"));
                finish();
                break;
            /*接收粘性事件数据按钮的点击事件处理*/
            case R.id.btn_eventbus_send_sticky:
                if (isRegist) {
                    EventBus.getDefault().register(this);
                    isRegist = false;
                }
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void StickyEvent(StickyEvent event) {
        tv_result.setText(event.msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
