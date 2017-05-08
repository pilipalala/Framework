package com.example.administrator.demo.Framework.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseFragment;
import com.example.administrator.demo.Framework.MyApplication;
import com.example.administrator.demo.Framework.ObservaleScrollView;
import com.example.administrator.demo.Framework.banner.GlideImageLoader;
import com.example.administrator.demo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/13.
 */
public class ThirdPartyFragment extends BaseFragment {
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.scrollView)
    ObservaleScrollView scrollView;
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.ll_root)
    LinearLayout llRoot;
    private static final String TAG = "CustomFragment";
    @Bind(R.id.banner)
    Banner banner;

    @Override
    protected View initView() {
        Log.e(TAG, "第三方控件页面初始化了...");

        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_third_party, null);
        ButterKnife.bind(this, view);




        return view;
    }

    @Override
    protected void initData() {
        super.initData();
            Log.e(TAG, "第三方控件数据初始化了...");
            banner.setImages(MyApplication.images)
                    .setImageLoader(new GlideImageLoader())
                    .setIndicatorGravity(BannerConfig.RIGHT)
                    .start();
            llRoot.getBackground().mutate().setAlpha(0);
            scrollView.setScrollViewListener(new ObservaleScrollView.ScrollViewListener() {
                @Override
                public void onScrollChanged(ObservaleScrollView scrollView, int x, int y, int oldx, int oldy) {
                    if (y <= banner.getHeight() && y >= 0) {

                        float scale = (float) y / banner.getHeight();
                        float alpha = (255 * scale);
                        text.setTextColor(Color.argb((int) alpha, 255, 255, 255));
                        llRoot.getBackground().mutate().setAlpha((int) alpha);
                    } else if (y > banner.getHeight()) {
                        llRoot.getBackground().mutate().setAlpha(255);
                    }
                }
            });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
