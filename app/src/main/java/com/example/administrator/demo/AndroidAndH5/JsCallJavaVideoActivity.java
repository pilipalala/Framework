package com.example.administrator.demo.AndroidAndH5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.demo.R;

public class JsCallJavaVideoActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_call_java_video);

        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        //设置支持javaScript脚步语言
        webSettings.setJavaScriptEnabled(true);

        //支持双击-前提y
        //设置客户端-不跳转到默认浏览器中
        webView.setWebViewClient(new WebViewClient());

        //加载网络资源
//        webView.loadUrl("http://atguigu.com/teacher.shtml");
        webView.addJavascriptInterface(new JsCallJava(), "android");
        webView.loadUrl("file:///android_asset/RealNetJSCallJavaActivity.htm");
    }

    class JsCallJava {
        @JavascriptInterface
        public void playVideo(int id, String videoUrl, String tile) {
            //调起系统所有播放器
            Intent intent = new Intent();
            intent.setDataAndType(Uri.parse(videoUrl), "video/*");
            startActivity(intent);
        }

    }
}
