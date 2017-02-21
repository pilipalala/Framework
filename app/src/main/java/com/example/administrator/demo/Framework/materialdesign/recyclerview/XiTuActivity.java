package com.example.administrator.demo.Framework.materialdesign.recyclerview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.tablayout.adapter.ViewPagerAdapter;
import com.example.administrator.demo.Framework.tablayout.fragment.MyFragment;
import com.example.administrator.demo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class XiTuActivity extends BaseActivity {
    @Bind(R.id.head_iv)
    ImageView headIv;
    @Bind(R.id.one)
    LinearLayout one;
    @Bind(R.id.two)
    LinearLayout two;
    @Bind(R.id.three)
    LinearLayout three;
    @Bind(R.id.head_layout)
    LinearLayout headLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.toolbar_tab)
    TabLayout toolbarTab;
    @Bind(R.id.appBar)
    AppBarLayout appBar;
    @Bind(R.id.main_vp_container)
    ViewPager mainVpContainer;
    @Bind(R.id.root_layout)
    CoordinatorLayout rootLayout;
    private ArrayList<MyFragment> fragments;
    private String[] tabTitles = new String[]{"", "分享", "收藏", "关注", "关注者"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xi_tu);
        ButterKnife.bind(this);

        fragments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fragments.add(new MyFragment(tabTitles[i], 5 + i));
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
                onBackPressed();
            }
        });
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -headLayout.getHeight() / 2) {
                    collapsingToolbar.setTitle("噼里啪啦");
                } else {
                    collapsingToolbar.setTitle("");
                }
            }
        });
        mainVpContainer.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        //tablayout和viewpager建立联系为什么不用下面这个方法呢？自己去研究一下，可能收获更多
//        toolbarTab.setupWithViewPager(mainVpContainer);

        mainVpContainer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
                (toolbarTab));
        toolbarTab.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
                (mainVpContainer));



        loadBlurAndSetStatusBar();
        Glide.with(this).load(R.mipmap.head).bitmapTransform(new RoundedCornersTransformation(this,
                90, 0)).into(headIv);


    }

    /**
     * 设置毛玻璃效果和沉浸栏
     */
    private void loadBlurAndSetStatusBar() {
        Glide.with(this).load(R.mipmap.atguigu_logo).bitmapTransform(new BlurTransformation(this, 100)).into(new SimpleTarget<GlideDrawable>() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                headLayout.setBackground(resource);
                rootLayout.setBackground(resource);
            }

        });
        Glide.with(this).load(R.mipmap.atguigu_logo).bitmapTransform(new BlurTransformation(this, 100))
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super
                            GlideDrawable> glideAnimation) {
                        collapsingToolbar.setContentScrim(resource);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);
        return true;
    }
}
