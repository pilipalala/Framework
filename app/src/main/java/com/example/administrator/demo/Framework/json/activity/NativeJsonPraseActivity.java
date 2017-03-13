package com.example.administrator.demo.Framework.json.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.json.bean.DataInfo;
import com.example.administrator.demo.Framework.json.bean.FileInfo;
import com.example.administrator.demo.Framework.json.bean.ShopInfo;
import com.example.administrator.demo.Framework.DataUtil;
import com.example.administrator.demo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*手动json解析界面*/
/*
* （1）将json格式的字符串{}转换为Java对象
* （2）将json格式的字符串[]转换为Java对象的List
* （3）复杂json数据解析
* （4）特殊json数据解析
* */
public class NativeJsonPraseActivity extends BaseActivity implements View.OnClickListener {
    private Button btNativeTojavaobject;
    private Button btNativeTojavalist;
    private Button btNativeComplex;
    private Button btNativeSpecial;
    private TextView tvTitle;
    private TextView tvNativeOrignal;
    private TextView tvNativeLast;
    private ShopInfo shopInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_json_prase);
        findViews();
    }


    private void findViews() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText("手动JSON解析");
        btNativeTojavaobject = (Button) findViewById(R.id.bt_native_tojavaobject);
        btNativeTojavalist = (Button) findViewById(R.id.bt_native_tojavalist);
        btNativeComplex = (Button) findViewById(R.id.bt_native_complex);
        btNativeSpecial = (Button) findViewById(R.id.bt_native_special);
        tvNativeLast = (TextView) findViewById(R.id.tv_native_last);
        tvNativeOrignal = (TextView) findViewById(R.id.tv_native_orignal);
        btNativeTojavaobject.setOnClickListener(this);
        btNativeTojavalist.setOnClickListener(this);
        btNativeComplex.setOnClickListener(this);
        btNativeSpecial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == btNativeTojavaobject) {//将json格式的字符串{}转换为Java对象
            jsonToJavaOjectByNative();
        } else if (v == btNativeTojavalist) {//将json格式的字符串[]转换为Java对象的List
            javaToJavaListByNative();
        } else if (v == btNativeComplex) {//复杂json数据解析
            javaToJavaOfComplex();
        } else if (v == btNativeSpecial) {//特殊json数据解析
            javaToJavaOfSpecial();
        }
    }

    /**
     * 特殊json数据解析
     * 从第一层封装
     */
    private void javaToJavaOfSpecial() {
        String json = DataUtil.specialOfJson;
        List<FileInfo.FileBean> fileBeans = new ArrayList<>();
        // 创建封装的Java对象
        FileInfo fileInfo = new FileInfo();
        try {
            JSONObject jsonObject = new JSONObject(json);
            /*第一层解析*/
            int code = jsonObject.optInt("code");
            JSONObject list = jsonObject.optJSONObject("list");
            /*第一层封装*/
            fileInfo.setCode(code);
            List<FileInfo.FileBean> lists = new ArrayList<>();
            fileInfo.setList(lists);
            /*第二层解析*/
            for (int i = 0; i < list.length(); i++) {
                JSONObject jsonObject1 = list.optJSONObject(i + "");
                if (jsonObject1 != null) {
                    String aid = jsonObject1.optString("aid");
                    String author = jsonObject1.optString("author");
                    int coins = jsonObject1.optInt("coins");
                    String copyright = jsonObject1.optString("copyright");
                    String create = jsonObject1.optString("create");
                    /*第二层数据封装*/
                    FileInfo.FileBean fileBean = new FileInfo.FileBean();
                    fileBean.setAid(aid);
                    fileBean.setAuthor(author);
                    fileBean.setCoins(coins);
                    fileBean.setCopyright(copyright);
                    fileBean.setCreate(create);
                    lists.add(fileBean);
                }
            }
            tvNativeOrignal.setText(json);
            tvNativeLast.setText(fileInfo.toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 复杂json数据解析
     */
    private void javaToJavaOfComplex() {
        String json = DataUtil.complexOfJson;
        DataInfo dataInfo = new DataInfo();
        try {
            JSONObject jsonObject = new JSONObject(json);
            /*解析第一层数据*/
            JSONObject data = jsonObject.optJSONObject("data");
            String rs_code = jsonObject.optString("rs_code");
            String rs_msg = jsonObject.optString("rs_msg");
            /*第一层封装*/
            dataInfo.setRs_code(rs_code);
            dataInfo.setRs_msg(rs_msg);
            DataInfo.DataBean dataBean = new DataInfo.DataBean();
            dataInfo.setData(dataBean);
            
            /*解析第二层数据*/
            int count = data.optInt("count");
            JSONArray items = data.optJSONArray("items");
            dataBean.setCount(count);
            /*第二层数据的封装*/
            List<DataInfo.DataBean.ItemsBean> itemsBean = new ArrayList<>();
            dataBean.setItems(itemsBean);
            /*解析第三层数据*/
            for (int i = 0; i < items.length(); i++) {
                JSONObject itemsJSONObject = items.getJSONObject(i);
                if (itemsJSONObject != null) {
                    int id = itemsJSONObject.optInt("id");
                    String title = itemsJSONObject.optString("title");
                    /*第三层数据的封装*/
                    DataInfo.DataBean.ItemsBean item = new DataInfo.DataBean.ItemsBean();
                    item.setId(id);
                    item.setTitle(title);
                    itemsBean.add(item);
                }
            }

            tvNativeOrignal.setText(json);
            tvNativeLast.setText(dataInfo.toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    /**
     * 将json格式的字符串[]转换为Java对象的List
     */
    private void javaToJavaListByNative() {
        //获取JSON数据
        String json = DataUtil.listOfJson;
        //解析JSON数据
        List<ShopInfo> shops = new ArrayList<ShopInfo>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject != null) {
                    int id = jsonObject.optInt("id");
                    String name = jsonObject.optString("name");
                    double price = jsonObject.optDouble("price");
                    String imagePath = jsonObject.optString("imagePath");
                    ShopInfo shopInfo = new ShopInfo(id, name, price, imagePath);
                    shops.add(shopInfo);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //显示JSON数据
        tvNativeOrignal.setText(json);
        tvNativeLast.setText(shops.toString());

    }

    /**
     * 将json格式的字符串{}转换为Java对象
     */
    private void jsonToJavaOjectByNative() {
        //获取JSON数据
        String json = DataUtil.objectOfJson;
        //解析json
        try {
            JSONObject jsonObject = new JSONObject(json);
            int id = jsonObject.getInt("id");
            int id1 = jsonObject.optInt("id");
            String name = jsonObject.optString("name");
            double price = jsonObject.optDouble("price");
            String imagePath = jsonObject.optString("imagePath");
            shopInfo = new ShopInfo(id, name, price, imagePath);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //显示json数据
        tvNativeOrignal.setText(json);
        tvNativeLast.setText(shopInfo.toString());
    }

}
