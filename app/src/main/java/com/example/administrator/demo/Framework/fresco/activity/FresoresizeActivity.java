package com.example.administrator.demo.Framework.fresco.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FresoresizeActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.sdv_fresco_resize)
    SimpleDraweeView sdvFrescoResize;
    @Bind(R.id.bt_fresco_resize)
    Button btFrescoResize;
    @Bind(R.id.bt_fresco_rotate)
    Button btFrescoRotate;
    Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/meinv.jpg"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresoresize);
        ButterKnife.bind(this);
        tvTitle.setText("图片缩放和旋转");
    }

    @OnClick({R.id.bt_fresco_resize, R.id.bt_fresco_rotate})
    public void onClick(View view) {
        switch (view.getId()) {
            /*a)缩放  修内存中改图片大小*/
            case R.id.bt_fresco_resize:

                ResizeOptions options = new ResizeOptions(100, 100);
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setResizeOptions(options)
                        .build();
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(sdvFrescoResize.getController())
                        .build();
                sdvFrescoResize.setController(controller);
                break;
            /*b)旋转图片*/
            case R.id.bt_fresco_rotate:
                ImageRequest request1 = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setAutoRotateEnabled(true)
                        .build();

                DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request1)
                        .setOldController(sdvFrescoResize.getController())
                        .build();
                sdvFrescoResize.setController(controller1);
                break;
        }
    }
}
