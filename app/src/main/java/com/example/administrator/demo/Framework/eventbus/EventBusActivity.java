package com.example.administrator.demo.Framework.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class EventBusActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_send, btn_sticky;
    private TextView tv_title, tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        /*1.注册*/
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_send = (Button) findViewById(R.id.btn_eventbus_send);
        btn_sticky = (Button) findViewById(R.id.btn_eventbus_sticky);
        tv_result = (TextView) findViewById(R.id.tv_eventbus_result);
        btn_send.setOnClickListener(this);
        btn_sticky.setOnClickListener(this);
        tv_title.setText("eventBus");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /*跳转到发送页面*/
            case R.id.btn_eventbus_send:
                startActivity(new Intent(EventBusActivity.this, EventBusSendActivity.class));
                break;
            /*发送粘性事件到发送页面*/
            case R.id.btn_eventbus_sticky:
                EventBus.getDefault().postSticky(new StickyEvent("粘性事件"));
                startActivity(new Intent(EventBusActivity.this, EventBusSendActivity.class));
                break;
        }
    }

    /*5.接收消息*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent event) {
        /*显示接收的消息*/
        tv_result.setText(event.name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*2.解注册*/
        EventBus.getDefault().unregister(this);
    }
}
