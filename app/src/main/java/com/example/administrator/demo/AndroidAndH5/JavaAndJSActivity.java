package com.example.administrator.demo.AndroidAndH5;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.demo.R;

public class JavaAndJSActivity extends Activity implements View.OnClickListener {
    private EditText etNumber;
    private EditText etPassword;
    private Button btnLogin;
    WebView webView;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-12-11 16:26:23 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        etNumber = (EditText) findViewById(R.id.et_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-12-11 16:26:23 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            // Handle clicks for btnLogin
            gologin();
        }
    }

    private void gologin() {
        String number = etNumber.getText().toString().trim();
        String passwd = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(number) || TextUtils.isEmpty(passwd)) {
            Toast.makeText(JavaAndJSActivity.this, "帐号或密码为空！！", Toast.LENGTH_SHORT).show();
        } else {
            login(number);
        }
    }

    private void login(String number) {

        webView.loadUrl("javascript:javaCallJs(" + "'" + number + "'" + ")");
        setContentView(webView);
    }

    class JsCallJava {
        @JavascriptInterface
        public void showToast() {
            Toast.makeText(JavaAndJSActivity.this, "点击Android被调用", Toast.LENGTH_SHORT).show();
        }
    }

    private void initWebView() {
        webView = new WebView(this);
        WebSettings webSetting = webView.getSettings();
        //设置支持javaScript脚步语言
        webSetting.setJavaScriptEnabled(true);
        //支持双击-前提是页面要支持才显示
        webSetting.setUseWideViewPort(true);
        //支持缩放按钮-前提是页面要支持才显示
        webSetting.setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new JsCallJava(), "Android");
        webView.loadUrl("file:///android_asset/JavaAndJavaScriptCall.html");
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_and_js);
        findViews();
        initWebView();
    }
}
