package com.example.administrator.demo.Main;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.demo.AndroidAndH5.Main;
import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView lv;
    private com.github.clans.fab.FloatingActionButton fab1, fab2, fab3;
    private RelativeLayout ll;
    private Boolean scrollFlag = false;
    private Animation mShowAction, mHiddenAction, mScaleAction, mScaleShow;
    private int j = 0;
    private ArrayAdapter<String> adapter;
    private List<String> data;
    private String mobile = "18356086769";


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (RelativeLayout) findViewById(R.id.llId);

        lv = (ListView) findViewById(R.id.lvId);
        data = getData();
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, data.get(i), Toast.LENGTH_SHORT).show();

                if (data.get(i).equals("ViewPager滑动")) {
                    startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
                } else if (data.get(i).equals("SwipeRefresh下拉刷新")) {
                    startActivity(new Intent(MainActivity.this, SwipeRefresh.class));
                } else if (data.get(i).equals("打电话")) {
                    callDirectly(mobile);
                } else if (data.get(i).equals("2")) {
                    startActivity(new Intent(MainActivity.this, HuoDongActivity.class));
                } else if (data.get(i).equals("7")) {
                    startActivity(new Intent(MainActivity.this, ActivityFragment.class));
                }else if (data.get(i).equals("8")) {
                    startActivity(new Intent(MainActivity.this, XinWenActivity.class));
                }else if (data.get(i).equals("9")) {
                    startActivity(new Intent(MainActivity.this, Main.class));
                }
            }
        });
        /*Animation.RELATIVE_TO_PARENT，相对于父控件，1f表示整个父控件的宽度或者是高度，
        0.5f表示父控件的高度或者宽度的一半，
        Animation.RELATIVE_TO_SELF，相对于自身控件，
        前面两个参数是旋转的角度，后面四个参数用来定义旋转的圆心*/
        mShowAction = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(200);
        mHiddenAction = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        mHiddenAction.setDuration(200);
        //前四个参数表示从原来大小的100%缩小到10%，后四个参数是为确定“中心点”
        mScaleAction = new ScaleAnimation(
                1, 0.1f,
                1, 0.1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mScaleAction.setDuration(200);
        mScaleShow = new ScaleAnimation(
                0.1f, 1,
                0.1f, 1,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mScaleShow.setDuration(200);

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE://停止的时候
                        fab1.setVisibility(View.VISIBLE);
                        fab1.startAnimation(mShowAction);
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:// 正在滚动
                        fab1.setVisibility(View.GONE);
                        //fab1.startAnimation(mScaleAction);
                        fab1.startAnimation(mHiddenAction);
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:// 是当用户由于之前划动屏幕并抬起手指，屏幕产生惯性滑动时
                        Toast.makeText(MainActivity.this, "再冲一会", Toast.LENGTH_SHORT).show();
                        break;
                }
            }


            /**
             * ListView滚动时会一直调用
             * int firstVisibleItem, 当前能看到的第一个item
             * int ivisibleItemCount, 当前能看到的item总数
             * int totallItemCount 整个listview的item总数
             * */
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int ivisibleItemCount, int totallItemCount) {
                Log.d("qqqqqqqqqqqqqqqqqqqqqq", "onScroll");


            }
        });
        fab1 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab1Id);
        fab2 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab2Id);
        fab3 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab3Id);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAB1", Toast.LENGTH_SHORT).show();
                int i = fab2.getVisibility();
                if (i == View.VISIBLE) {
                    fab2.setVisibility(View.GONE);
                    fab2.startAnimation(mScaleAction);
                    fab3.setVisibility(View.GONE);
                    fab3.startAnimation(mScaleAction);
                } else {
                    fab2.setVisibility(View.VISIBLE);
                    fab2.startAnimation(mScaleShow);
                    fab3.setVisibility(View.VISIBLE);
                    fab3.startAnimation(mScaleShow);
                }
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAB2", Toast.LENGTH_SHORT).show();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAB3", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private List<String> getData() {

        data = new ArrayList<String>();
        data.add("ViewPager滑动");
        data.add("SwipeRefresh下拉刷新");
        data.add("打电话");
        data.add("PullToRefresh");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        data.add("9");
        data.add("10");
        data.add("11");
        data.add("12");
        data.add("13");
        data.add("14");
        data.add("15");
        data.add("16");
        data.add("17");
        data.add("18");
        data.add("19");
        data.add("20");
        data.add("21");
        data.add("22");
        data.add("23");
        data.add("24");
        data.add("25");
        data.add("26");
        data.add("27");
        data.add("28");
        data.add("29");
        data.add("30");
        data.add("31");
        data.add("32");
        data.add("33");
        data.add("34");
        data.add("35");
        data.add("36");
        data.add("37");
        data.add("38");


        return data;
    }

    private void callDirectly(String mobile) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + mobile));
        startActivity(intent);
    }

    /*private void onCall(String mobile) {
        if (Build.VERSION.SDK_INT >= 23) {
            int checkCallPermiss = checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (checkCallPermiss != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_CALL_PHONE);
            }else {
                callDirectly(mobile);
            }
        }else{
            callDirectly(mobile);
        }

    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 123:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    callDirectly(mobile);
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "CALL_PHONE Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
