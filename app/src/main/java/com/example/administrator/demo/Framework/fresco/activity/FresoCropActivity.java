package com.example.administrator.demo.Framework.fresco.activity;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FresoCropActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.sdv_fresco_crop)
    SimpleDraweeView sdvFrescoCrop;
    @Bind(R.id.tv_fresco_explain)
    TextView tvFrescoExplain;
    @Bind(R.id.bt_fresco_center)
    Button btFrescoCenter;
    @Bind(R.id.bt_fresco_centercrop)
    Button btFrescoCentercrop;
    @Bind(R.id.bt_fresco_focuscrop)
    Button btFrescoFocuscrop;
    @Bind(R.id.bt_fresco_centerinside)
    Button btFrescoCenterinside;
    @Bind(R.id.bt_fresco_fitcenter)
    Button btFrescoFitcenter;
    @Bind(R.id.bt_fresco_fitstart)
    Button btFrescoFitstart;
    @Bind(R.id.bt_fresco_fitend)
    Button btFrescoFitend;
    @Bind(R.id.bt_fresco_fitxy)
    Button btFrescoFitxy;
    @Bind(R.id.bt_fresco_none)
    Button btFrescoNone;
    private GenericDraweeHierarchyBuilder builder;
    private GenericDraweeHierarchy hierarchy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freso_crop);
        ButterKnife.bind(this);
        tvTitle.setText("图片的不同裁剪");
        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @OnClick({R.id.bt_fresco_center, R.id.bt_fresco_centercrop, R.id.bt_fresco_focuscrop, R.id.bt_fresco_centerinside, R.id.bt_fresco_fitcenter, R.id.bt_fresco_fitstart, R.id.bt_fresco_fitend, R.id.bt_fresco_fitxy, R.id.bt_fresco_none})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_center:
                tvFrescoExplain.setText("居中，无缩放");
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER).build();
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_centercrop:
                tvFrescoExplain.setText("保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示");
                builder = new GenericDraweeHierarchyBuilder(getResources());
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_focuscrop:
                tvFrescoExplain.setText("同centerCrop, 但居中点不是中点，而是指定的某个点,这里我设置为图片的左上角那点");
                //设置focusCrop的缩放形式  并指定缩放的中心点在左上角
                PointF point = new PointF(0f, 0f);
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP)
                        .setActualImageFocusPoint(point)
                        .build();
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_centerinside:
                tvFrescoExplain.setText("使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片");
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build();
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_fitcenter:
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示");
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_fitstart:
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐");
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build();
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_fitend:
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐");
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END).build();
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_fitxy:
                tvFrescoExplain.setText("不保持宽高比，填充满显示边界");
                hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
                imageDisplay(hierarchy);
                break;
            case R.id.bt_fresco_none:
                tvFrescoExplain.setText("如要使用tile mode显示, 需要设置为none");
                hierarchy = builder.setActualImageScaleType(null).build();
                break;
        }
    }
    private void imageDisplay(GenericDraweeHierarchy hierarchy) {
        sdvFrescoCrop.setHierarchy(hierarchy);
//        Uri uri = Uri.parse("res://包名(实际可以是任何字符串甚至留空)/" + R.drawable.ic_launcher);/**/
        Uri uri = Uri.parse("res:// /"+R.mipmap.mine);
        sdvFrescoCrop.setImageURI(uri);

    }
}
