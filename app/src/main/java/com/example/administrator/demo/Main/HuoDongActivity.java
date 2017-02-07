package com.example.administrator.demo.Main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.administrator.demo.Main.utils.PopWindow;


/**
 * Created by Administrator on 2016/10/15.
 */
public class HuoDongActivity extends Activity implements View.OnClickListener{
    private ImageView mBack, mAdd;
    private TextView mTitle;
    private PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huodong);
        initView();
    }

    protected void initView() {
        mBack = (ImageView) findViewById(R.id.title_back);
        mAdd = (ImageView) findViewById(R.id.title_right_add);
        mTitle = (TextView) findViewById(R.id.title_name);
        mTitle.setText("活动");
        mBack.setOnClickListener(this);
        mAdd.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_right_add:
//                startActivity(new Intent(HuoDongActivity.this,DialogActivity.class));
                PopWindow popWindow = new PopWindow(this);
                popWindow.showPopupWindow(findViewById(R.id.title_right_add));
                break;

        }

    }


}
