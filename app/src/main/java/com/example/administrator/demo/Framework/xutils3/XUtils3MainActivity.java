package com.example.administrator.demo.Framework.xutils3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.xutils3.annotation.FragmentXUtils3Activity;
import com.example.administrator.demo.Framework.xutils3.net.XUtils3NetActivity;
import com.example.administrator.demo.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_xutils3_main)
public class XUtils3MainActivity extends BaseActivity {
    @ViewInject(R.id.tv_title)
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_xutils3_main);
        x.view().inject(this);
        tv_title.setText("xUtils的使用");
    }

    @Event(value = {R.id.btn_annotation, R.id.btn_net, R.id.btn_image, R.id.btn_image_list})
    private void getEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_annotation:
                /*1.1_XUtils3MainActivity布局*/
                startActivity(new Intent(this, FragmentXUtils3Activity.class));
                break;
            case R.id.btn_net:
                startActivity(new Intent(this, XUtils3NetActivity.class));
                break;
            case R.id.btn_image:
                Toast.makeText(XUtils3MainActivity.this, "btn_image", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image_list:
                Toast.makeText(XUtils3MainActivity.this, "btn_image_list", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
