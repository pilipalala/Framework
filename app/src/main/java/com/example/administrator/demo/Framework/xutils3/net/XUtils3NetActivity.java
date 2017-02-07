package com.example.administrator.demo.Framework.xutils3.net;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

@ContentView(R.layout.activity_xutils3_net)
public class XUtils3NetActivity extends BaseActivity {

    @ViewInject(R.id.tv_title)
    private TextView title;
    @ViewInject(R.id.tv_result)
    private TextView tv_result;
    @ViewInject(R.id.progressBar)
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_xutils3_net);
        x.view().inject(this);
        title.setText("xUtils网络模块");
    }

    @Event(value = {R.id.btn_get_post, R.id.btn_downloadfile, R.id.btn_uploadfile})
    private void getEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_get_post:
                getDataByGet_Post();
                break;
            case R.id.btn_downloadfile:
                downloadfile();
                break;
            case R.id.btn_uploadfile:
                break;
        }
    }

    private void downloadfile() {
        RequestParams params = new RequestParams("http://vfx.mtime.cn/Video/2016/12/12/mp4/161212190638286683_480.mp4");
        /*设置保存路径*/
        params.setSaveFilePath(Environment.getExternalStorageDirectory()+"/wyj/480.mp4");
        /*设置是否可以立即取消下载*/
        params.setCancelFast(true);
        /*设置是否自动命名*/
        params.setAutoRename(false);
        x.http().get(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onWaiting() {

            }

            @Override
            public void onStarted() {

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                progressBar.setMax((int) total);
                progressBar.setProgress((int) current);
            }

            /*当下载成功时候回调这个方法，并把下载到那个路径回传过来*/
            @Override
            public void onSuccess(File file) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public void getDataByGet_Post() {

        RequestParams params = new RequestParams("http://api.m.mtime.cn/PageSubArea/TrailerList.api");

        x.http().get(params, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                tv_result.setText("get--->" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }
}
