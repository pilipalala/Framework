package com.example.administrator.demo.Framework.pulltorefresh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PullToRefreshActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.btn_ptr_listView)
    Button btnPtrListView;
    @Bind(R.id.btn_ptr_gridView)
    Button btnPtrGridView;
    @Bind(R.id.btn_ptr_fragment)
    Button btnPtrFragment;
    @Bind(R.id.btn_ptr_listInViewPager)
    Button btnPtrListForViewPager;
    @Bind(R.id.btn_ptr_viewPager)
    Button btnPtrViewPager;
    @Bind(R.id.btn_ptr_webView)
    Button btnPtrWebView;
    @Bind(R.id.btn_ptr_webView2)
    Button btnPtrWebView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);
        ButterKnife.bind(this);
        tvTitle.setText("Android-PullToRefresh");
    }

    @OnClick({R.id.btn_ptr_listView, R.id.btn_ptr_gridView, R.id.btn_ptr_fragment, R.id.btn_ptr_listInViewPager, R.id.btn_ptr_viewPager, R.id.btn_ptr_webView,R.id.btn_ptr_webView2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ptr_listView:
                startActivity(new Intent(this, PullToRefreshListActivity.class));
                break;
            case R.id.btn_ptr_gridView:
                startActivity(new Intent(this, PullToRefreshGridActivity.class));
                break;
            case R.id.btn_ptr_fragment:
                startActivity(new Intent(this, PullToRefreshListFragmentActivity.class));
                break;
            case R.id.btn_ptr_listInViewPager:
                startActivity(new Intent(this, PullToRefreshListInViewPagerActivity.class));
                break;
            case R.id.btn_ptr_viewPager:
                startActivity(new Intent(this, PullToRefreshViewPagerActivity.class));
                break;
            case R.id.btn_ptr_webView:
                startActivity(new Intent(this, PullToRefreshWebViewActivity.class));
                break;
            case R.id.btn_ptr_webView2:
                startActivity(new Intent(this, PullToRefreshWebView2Activity.class));
                break;
        }
    }
}
