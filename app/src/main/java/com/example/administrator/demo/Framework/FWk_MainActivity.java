package com.example.administrator.demo.Framework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.administrator.demo.Framework.fragment.CommonFrameFragment;
import com.example.administrator.demo.Framework.fragment.CustomFragment;
import com.example.administrator.demo.Framework.fragment.OtherFragment;
import com.example.administrator.demo.Framework.fragment.ThirdPartyFragment;
import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

public class FWk_MainActivity extends FragmentActivity {
    private RadioGroup rg_main;
    private List<BaseFragment> mBaseFragment;
    private int position;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFragment();
        listener();
    }
    private void initView() {
        setContentView(R.layout.activity_fwk__main);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);

    }
    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFrameFragment());
        mBaseFragment.add(new ThirdPartyFragment());
        mBaseFragment.add(new CustomFragment());
        mBaseFragment.add(new OtherFragment());
    }
    private void listener() {
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        /*设置默认选中*/
        rg_main.check(R.id.rb_common);
    }


    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.rb_common:
                    position = 0;
                    break;
                case R.id.rb_third:
                    position = 1;
                    break;
                case R.id.rb_custom:
                    position = 2;
                    break;
                case R.id.rb_other:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }
            BaseFragment to = getFragment();
            switchFragment(mFragment, to);
        }
    }

    public BaseFragment getFragment() {
        BaseFragment baseFragment = mBaseFragment.get(position);
        return baseFragment;
    }

    /**
     * @param from 刚显示的Fragment。马上就要被隐藏
     * @param to   马上要切换的Fragment。 一会要显示
     */
    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {//才切换
            mFragment = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {//to没被添加
                //隐藏from
                if (from != null) {
                    transaction.hide(from);
                }
                //添加to
                if (to != null) {
                    transaction.add(R.id.fl_content, to).commit();
                }
            } else {
                //隐藏from
                if (from != null) {
                    transaction.hide(from);
                }
                //显示to
                if (to != null) {
                    transaction.show(to).commit();
                }
            }
        }
    }
    /*private void switchFragment(BaseFragment fragment) {
        //1.得到FragmentManger
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        //3.替换
        transaction.replace(R.id.fl_content, fragment);
        //4.提交事务
        transaction.commit();
    }*/




}
