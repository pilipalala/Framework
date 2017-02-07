package com.example.administrator.demo.Framework.fresco.activity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FresoAutoSizeActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.bt_fresco_loadsmall)
    Button btFrescoLoadsmall;
    @Bind(R.id.ll_fresco)
    LinearLayout llFresco;

    private SimpleDraweeView simpleDraweeView;
    private Uri uri = Uri.parse("res:// /" + R.mipmap.atguigu_logo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freso_auto_size);
        ButterKnife.bind(this);
        tvTitle.setText("动态展示图片");
        simpleDraweeView = new SimpleDraweeView(this);
        /*设置宽高比*/
        simpleDraweeView.setAspectRatio(1.0f);/*宽度是高度的n倍*/
    }

    @OnClick(R.id.bt_fresco_loadsmall)
    public void onClick() {
        if (simpleDraweeView != null) {
            llFresco.removeAllViews();
        }
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).build();
        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
        /*添加view到线性布局中*/
        llFresco.addView(simpleDraweeView);
    }

    /*final Uri uri = Uri.parse("http://img4q.duitang.com/uploads/item/201304/27/20130427043538_wAfHC.jpeg");


        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .build();

        PipelineDraweeController controller = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(simpleDraweeView.getController())
                        .build();

        simpleDraweeView.setController(controller);

        llFresco.addView(simpleDraweeView);*/

}
