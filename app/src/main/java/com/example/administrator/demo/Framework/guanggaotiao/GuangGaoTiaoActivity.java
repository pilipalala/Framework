package com.example.administrator.demo.Framework.guanggaotiao;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuangGaoTiaoActivity extends BaseActivity {

    @Bind(R.id.gg_viewpager)
    ViewPager ggViewpager;
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.ll_point)
    LinearLayout llPoint;
    private ArrayList<ImageView> imageViewList;
    // 图片资源ID
    private final int[] imageIds = {
            R.mipmap.a,
            R.mipmap.b,
            R.mipmap.c,
            R.mipmap.d,
            R.mipmap.e };
    // 图片标题集合
    private final String[] imageDescriptions = {
            "尚硅谷波河争霸赛！",
            "凝聚你我，放飞梦想！",
            "抱歉没座位了！",
            "7月就业名单全部曝光！",
            "平均起薪11345元"
    };


    /**
     * ViewPager的使用
     * 1、在布局文件中定义viewPager
     * 2、在代码中实例化ViewPager
     * 3、准备数据
     * 4、设置适配器（PagerAdapter）
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guang_gao_tiao);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        for (int i = 0; i < imageIds.length; i++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(imageIds[i]);
            imageViewList.add(image);
        }
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this, imageViewList);
//        设置适配器（PagerAdapter）

        ggViewpager.setAdapter(adapter);

    }
}
