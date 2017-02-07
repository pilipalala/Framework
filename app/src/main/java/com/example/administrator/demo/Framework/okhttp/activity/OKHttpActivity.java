package com.example.administrator.demo.Framework.okhttp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "OKHttpActivity";
    private static final MediaType JSON = MediaType.parse("application/json;charse=utf-8");
    private static final int GET = 0;
    private static final int POST = 1;
    private Button btn_get, btn_post, btn_get_httptuils, btn_post_httptuils, btn_download,btn_cainiao;
    private TextView tv_result;
    private OkHttpClient client = new OkHttpClient();
    private ProgressBar progressBar;
    private Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET:
                    tv_result.setText((String) msg.obj);
                    break;
                case POST:
                    tv_result.setText((String) msg.obj);
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_post = (Button) findViewById(R.id.btn_post);
        tv_result = (TextView) findViewById(R.id.tv_result);
        btn_get_httptuils = (Button) findViewById(R.id.btn_get_httptuils);
        btn_post_httptuils = (Button) findViewById(R.id.btn_post_httptuils);
        btn_download = (Button) findViewById(R.id.btn_download);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btn_cainiao = (Button) findViewById(R.id.btn_cainiao);
        btn_download.setOnClickListener(this);
        btn_post_httptuils.setOnClickListener(this);
        btn_get_httptuils.setOnClickListener(this);
        btn_get.setOnClickListener(this);
        btn_post.setOnClickListener(this);
        btn_cainiao.setOnClickListener(this);
    }

    /**
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /*get请求*/
            case R.id.btn_get:
                tv_result.setText("");
                getDataFromGet();
                break;
            /*post请求*/
            case R.id.btn_post:
                tv_result.setText("");
                getDataFromPost();
                break;
            /*使用http-utils的get请求*/
            case R.id.btn_get_httptuils:
                getHtml();
                break;
            /*使用http-utils的post请求*/
            case R.id.btn_post_httptuils:
                postHtml();
                break;
            /*使用http-utils下载文件*/
            case R.id.btn_download:
                downloadFile();
                break;
            /*菜鸟窝版本的OkHttp*/
            case R.id.btn_cainiao:
                startActivity(new Intent(this, CaiNiaoWoActivity.class));
                break;
        }
    }

    /**
     * 使用post请求网络数据
     */
    private void getDataFromPost() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String result = post("http://api.m.mtime.cn/PageSubArea/TrailerList.api", "");
                    Message msg = Message.obtain();
                    msg.what = POST;
                    msg.obj = result;
                    handle.sendMessage(msg);
                    Log.e(TAG, "onClick: " + result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    /**
     * 使用get请求网络数据
     */
    private void getDataFromGet() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String result = get("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
                    Message msg = Message.obtain();
                    msg.what = GET;
                    msg.obj = result;
                    handle.sendMessage(msg);
                    Log.e(TAG, "onClick: " + result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    /**
     * get请求
     *
     * @param url 网络连接
     * @return
     * @throws IOException
     */
    private String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    /**
     * okhttp3的post请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * 使用okhttp-utils的get请求
     */
    public void getHtml() {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
//        url="http://www.3191k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        OkHttpUtils
                .get()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    /**
     * 使用okhttp—utils的post请求
     */
    public void postHtml() {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
//        url="http://www.3191k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        OkHttpUtils
                .post()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    /**
     * 使用okhttp-utils下载大文件
     *
     * @param view
     */
    public void downloadFile() {
        String url = "http://vf1.mtime.cn/Video/2016/12/06/mp4/161206120829574892_480.mp4";
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "变形金刚5.mp4")//
                {

                    @Override
                    public void onBefore(Request request, int id) {
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        progressBar.setProgress((int) (100 * progress));
                        Log.e(TAG, "inProgress :" + (int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id) {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                    }
                });
    }


    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {
            setTitle("loading...");
        }

        @Override
        public void onAfter(int id) {
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
            tv_result.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e(TAG, "onResponse：complete");
            tv_result.setText("onResponse:" + response);

            switch (id) {
                case 100:
                    Toast.makeText(OKHttpActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(OKHttpActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
            Log.e(TAG, "inProgress:" + progress);
//            progressBar.setProgress((int) (100 * progress));
        }
    }
}
