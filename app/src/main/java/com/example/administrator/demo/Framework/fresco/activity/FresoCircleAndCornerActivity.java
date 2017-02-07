package com.example.administrator.demo.Framework.fresco.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FresoCircleAndCornerActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.sdv_fresco_circleandcorner)
    SimpleDraweeView sdvFrescoCircleandcorner;
    @Bind(R.id.bt_fresco_circle)
    Button btFrescoCircle;
    @Bind(R.id.bt_fresco_corner)
    Button btFrescoCorner;
    private GenericDraweeHierarchyBuilder builder;
    private GenericDraweeHierarchy hierarchy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freso_circle_and_corner);
        ButterKnife.bind(this);
        tvTitle.setText("圆形和圆角图片");
        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @OnClick({R.id.bt_fresco_circle, R.id.bt_fresco_corner})
    public void onClick(View view) {
        switch (view.getId()) {
                /* 设置圆形图片*/
            case R.id.bt_fresco_circle:
                // 参数设置为圆形
                hierarchy = builder.setRoundingParams(RoundingParams.asCircle()).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);
                imageDisplay();
                break;
                /*设置圆角图片*/
            case R.id.bt_fresco_corner:
                // 配置参数
                // RoundingParams.fromCornersRadius(50f);//设置圆角大小
                RoundingParams params = RoundingParams.fromCornersRadii(50f,100f,150f,200f);//设置四个圆角大小
                params.setOverlayColor(getResources().getColor(android.R.color.holo_red_light));//覆盖层
                params.setBorder(getResources().getColor(android.R.color.holo_blue_light), 5);//边框
                params.setRoundAsCircle(false);//如果是RoundingParams.fromCornersRadius，这个可以强制进行圆形展示

                // 设置圆形参数
                hierarchy = builder.setRoundingParams(params).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);
                imageDisplay();
                break;
        }
    }

    /**
     * 加载图片
     */
    private void imageDisplay() {
        Uri uri = Uri.parse("res:// /"+ R.mipmap.mine);
        // 加载图片
        sdvFrescoCircleandcorner.setImageURI(uri);
    }
}
