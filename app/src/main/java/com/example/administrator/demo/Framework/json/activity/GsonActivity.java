package com.example.administrator.demo.Framework.json.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.json.bean.ShopInfo;
import com.example.administrator.demo.Framework.DataUtil;
import com.example.administrator.demo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


/*GSON解析页面*/
public class GsonActivity extends BaseActivity implements View.OnClickListener {
    private Button btGsonTojavaobject;
    private Button btGsonTojavalist;
    private Button btGsonJavatojsonobject;
    private Button btGsonJavatogosnarray;
    private TextView tvGsonOrignal;
    private TextView tvGsonLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        findViews();
    }

    private void findViews() {
        btGsonTojavaobject = (Button) findViewById(R.id.bt_gson_tojavaobject);
        btGsonTojavalist = (Button) findViewById(R.id.bt_gson_tojavalist);
        btGsonJavatojsonobject = (Button) findViewById(R.id.bt_gson_javatojsonobject);
        btGsonJavatogosnarray = (Button) findViewById(R.id.bt_gson_javatogosnarray);
        tvGsonOrignal = (TextView) findViewById(R.id.tv_gson_orignal);
        tvGsonLast = (TextView) findViewById(R.id.tv_gson_last);

        btGsonTojavaobject.setOnClickListener(this);
        btGsonTojavalist.setOnClickListener(this);
        btGsonJavatojsonobject.setOnClickListener(this);
        btGsonJavatogosnarray.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btGsonTojavaobject) {//（1）将json格式的字符串{}转换为Java对象
            jsonToJavaObjectByGson();
        } else if (v == btGsonTojavalist) {
            jsonToJavaListByGson();
        } else if (v == btGsonJavatojsonobject) {
            javaToJsonObjectByGson();
        } else if (v == btGsonJavatogosnarray) {
            javaTojsonArrayByGson();
        }
    }

    /**
     * （4）将Java对象的List转换为json字符串[]
     */
    private void javaTojsonArrayByGson() {
        /*获取Java对象的list*/
        List<ShopInfo> shops = new ArrayList<>();
        ShopInfo baoyu = new ShopInfo(1, "鲍鱼", 250.0, "baoyu");
        ShopInfo longxia = new ShopInfo(2, "龙虾", 240.0, "longxia");

        shops.add(baoyu);
        shops.add(longxia);
        /*生存json对象*/
        Gson gson = new Gson();
        String json = gson.toJson(shops);
        /*显示数据*/
        tvGsonOrignal.setText(shops.toString());
        tvGsonLast.setText(json);
    }

    /**
     * （3）将Java对象转换为json字符串{}
     */
    private void javaToJsonObjectByGson() {

        /*获取Java对象*/
        ShopInfo shopInfo = new ShopInfo(1, "鲍鱼", 250.0, "baoyu");
        /*生存json对象*/
        Gson gson = new Gson();
        String json = gson.toJson(shopInfo);
        /*显示数据*/
        tvGsonOrignal.setText(shopInfo.toString());
        tvGsonLast.setText(json);

    }

    /**
     * （2）将json格式的字符串[]转换为Java对象的List
     */
    private void jsonToJavaListByGson() {
       /*1、创建json数据*/
        String json = DataUtil.listOfJson;
        /*2、解析json数据*/
        Gson gson = new Gson();
        List<ShopInfo> shops = gson.fromJson(json, new TypeToken<List<ShopInfo>>() {
        }.getType());
        /*3、展示数据*/
        tvGsonOrignal.setText(json);
        tvGsonLast.setText(shops.toString());
    }


    /**
     * （1）将json格式的字符串{}转换为Java对象
     */
    private void jsonToJavaObjectByGson() {
        /*1、创建json数据*/
        String json = DataUtil.objectOfJson;
        /*2、解析json数据*/
        Gson gson = new Gson();
        ShopInfo shopInfo = gson.fromJson(json, ShopInfo.class);
        /*3、展示数据*/
        tvGsonOrignal.setText(json);
        tvGsonLast.setText(shopInfo.toString());
    }
}
