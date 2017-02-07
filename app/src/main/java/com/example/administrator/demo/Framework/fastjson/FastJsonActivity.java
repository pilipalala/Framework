package com.example.administrator.demo.Framework.fastjson;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.json.bean.ShopInfo;
import com.example.administrator.demo.Main.utils.DataUtil;
import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FastJsonActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.bt_gson_tojavaobject)
    Button btGsonTojavaobject;
    @Bind(R.id.bt_gson_tojavalist)
    Button btGsonTojavalist;
    @Bind(R.id.bt_gson_javatojsonobject)
    Button btGsonJavatojsonobject;
    @Bind(R.id.bt_gson_javatogosnarray)
    Button btGsonJavatogosnarray;
    @Bind(R.id.tv_gson_orignal)
    TextView tvGsonOrignal;
    @Bind(R.id.tv_gson_last)
    TextView tvGsonLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_json);
        ButterKnife.bind(this);
        tvTitle.setText("FastJson解析");
    }

    @OnClick({R.id.bt_gson_tojavaobject, R.id.bt_gson_tojavalist, R.id.bt_gson_javatojsonobject, R.id.bt_gson_javatogosnarray})
    public void onClick(View view) {
        switch (view.getId()) {
            /*（1）将json格式的字符串{}转换为Java对象*/
            case R.id.bt_gson_tojavaobject:
                /*1、获取或创建json数据*/
                String json = DataUtil.objectOfJson;
                /*2、解析json数据*/
                ShopInfo shopInfo = JSON.parseObject(json, ShopInfo.class);
                /*3、显示数据*/
                tvGsonOrignal.setText(json);
                tvGsonLast.setText(shopInfo.toString());
                break;
            /*（2）将json格式的字符串[]转换为Java对象的List*/
            case R.id.bt_gson_tojavalist:
                /*1、获取json数据*/
                String json1 = DataUtil.listOfJson;
                /*2、解析json数据*/
                List<ShopInfo> list = JSON.parseArray(json1, ShopInfo.class);
                /*3、显示数据*/
                tvGsonOrignal.setText(json1);
                tvGsonLast.setText(list.toString());
                break;
            case R.id.bt_gson_javatojsonobject:
                ShopInfo shopInfo1 = new ShopInfo(1,"鲍鱼",240.0,"baoyu");
                String json2 = JSON.toJSONString(shopInfo1);
                tvGsonOrignal.setText(shopInfo1.toString());
                tvGsonLast.setText(json2);
                break;
            case R.id.bt_gson_javatogosnarray:
                /*创建list 集合*/
                List<ShopInfo> shopInfos = new ArrayList<>();
                ShopInfo shopInfo2 = new ShopInfo(1, "鲍鱼", 240.0, "baoyu");
                ShopInfo shopInfo3 = new ShopInfo(2, "牡蛎", 260.0, "muli");
                shopInfos.add(shopInfo2);
                shopInfos.add(shopInfo3);
                String json3 = JSON.toJSONString(shopInfos);
                tvGsonOrignal.setText(shopInfos.toString());
                tvGsonLast.setText(json3);
                break;
        }
    }
}
