package com.example.administrator.demo.Framework.okhttp.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CaiNiaoWoActivity extends BaseActivity {

    @Bind(R.id.btn_get)
    Button btnGet;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.tv_name)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_niao_wo);
        ButterKnife.bind(this);


       /*SimpleHttpClient.newBulid()
                .url("www.baidu.com")
                .get()
                .bulid()
                .enqueue(new BaseCallback<ShopInfo>() {
                    @Override
                    public void onSuccess(ShopInfo shopInfo) {

                    }

                    @Override
                    public void onError(int code) {

                    }

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }
                });*/
    }

    @OnClick(R.id.btn_get)
    public void onClick() {
        getUserInfo();
    }

    public void getUserInfo() {

        OkHttpClient client = new OkHttpClient();


//        http://jl.leyijilin.com/api.php?API=staff/entry/login&data={"mobile":"13800000000","passwd":123456}

        Request request = new Request.Builder()
                .get()
                .url("http://jl.leyijilin.com/api.php?API=staff/entry/login&data={\"mobile\":\"13800000000\",\"passwd\":123456}")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    Log.e("onFailure", "onResponse: " + result);
                    showUser(result);

                }

            }
        });
    }

    private void showUser(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                UserInfo json = JSON.parseObject(result, UserInfo.class);
                UserData data = json.getData();
                String name = data.getName();
                String pic = data.getFace();
                Log.e("onFailure", "name: " + name);
                Log.e("onFailure", "pic: " + pic);
                String staffId = data.getStaff_id();
                tvName.setText(name + "\n" + staffId);
                Picasso.with(CaiNiaoWoActivity.this).load("http://jl.leyijilin.com/attachs/" + pic).resize(200, 200).centerCrop().into(imageView);
            }
        });

    }
}
