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
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FresoMultiActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.sdv_fresco_multi)
    SimpleDraweeView sdvFrescoMulti;
    @Bind(R.id.bt_fresco_multiImg)
    Button btFrescoMultiImg;
    @Bind(R.id.bt_fresco_thumbnailImg)
    Button btFrescoThumbnailImg;
    @Bind(R.id.bt_fresco_multiplexImg)
    Button btFrescoMultiplexImg;
    ImageRequest request;
    DraweeController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freso_multi);
        ButterKnife.bind(this);
        tvTitle.setText("多图请求及图片复用");
    }

    @OnClick({R.id.bt_fresco_multiImg, R.id.bt_fresco_thumbnailImg, R.id.bt_fresco_multiplexImg})
    public void onClick(View view) {
        switch (view.getId()) {
            /*先显示低分辨率的图，然后是高分辨率的图*/
            case R.id.bt_fresco_multiImg:
                /*M*/
                /*图片地址*/
                Uri lowUri = Uri.parse("http://img1.gamedog.cn/2012/03/11/19-120311133617-50.jpg");
                Uri heightUri = Uri.parse("http://img5.duitang.com/uploads/item/201312/03/20131203153823_Y4y8F.jpeg");
                ImageRequest lowResult = ImageRequest.fromUri(lowUri);
                ImageRequest hightResult = ImageRequest.fromUri(heightUri);
                /*C*/
                /*控制加载图片*/
                controller = Fresco.newDraweeControllerBuilder()
                        .setLowResImageRequest(lowResult)//加载低分辨率图
                        .setImageRequest(hightResult)//加载高分辨率图
                        .setOldController(sdvFrescoMulti.getController())
                        .build();
                /*V*/
                /*加载图片*/
                sdvFrescoMulti.setController(controller);
                break;
            /*本地缩略图预览*/
            case R.id.bt_fresco_thumbnailImg:
                /*图片地址*/
                Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/meinv.jpg"));
                /*加载图片的请求*/
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setLocalThumbnailPreviewsEnabled(true)
                        .build();
                /*控制图片的加载*/

                controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .build();
                /*加载图片*/
                sdvFrescoMulti.setController(controller);
                break;
            /*本地图片复用*/
            case R.id.bt_fresco_multiplexImg:
                //在请求之前，还会去内存中请求一次图片，没有才会先去本地，最后去网络uri
                //本地准备复用图片的uri  如果本地这个图片不存在，会自动去加载下一个uri
                Uri uri1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/meinv1.jpg"));
                //图片的网络uri
                Uri uri2 = Uri.parse("http://img1.gamedog.cn/2012/03/11/19-120311133617-50.jpg");

                ImageRequest request1 = ImageRequest.fromUri(uri1);
                ImageRequest request2 = ImageRequest.fromUri(uri2);
                ImageRequest[] requests = {request1, request2};

                controller = Fresco.newDraweeControllerBuilder()
                        .setFirstAvailableImageRequests(requests)
                        .setOldController(sdvFrescoMulti.getController())
                        .build();

                sdvFrescoMulti.setController(controller);
                break;
        }
    }
}
