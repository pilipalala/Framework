package com.example.administrator.demo.Framework.fresco.activity;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FresoListenerActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.sdv_fresco_listener)
    SimpleDraweeView sdvFrescoListener;
    @Bind(R.id.bt_fresco_listener)
    Button btFrescoListener;
    @Bind(R.id.tv_fresco_listener)
    TextView tvFrescoListener;
    @Bind(R.id.tv_fresco_listener2)
    TextView tvFrescoListener2;
    private ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
        /*加载图片完毕*/
        @Override
        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
            super.onFinalImageSet(id, imageInfo, animatable);
            if (imageInfo == null) {
                return;
            }
            /*获取图片质量*/
            QualityInfo qualityInfo = imageInfo.getQualityInfo();

            tvFrescoListener.setText("Final image received! " +
                    "\n图片大小: " + imageInfo.getWidth()
                    + "x" + imageInfo.getHeight()
                    + "\n图片等级: " + qualityInfo.getQuality()
                    + "\n是否加载完成: " + qualityInfo.isOfGoodEnoughQuality()
                    + "\n完全等级: " + qualityInfo.isOfFullQuality());
        }

        /*渐进式加载图片回调*/
        @Override
        public void onIntermediateImageSet(String id, ImageInfo imageInfo) {
            super.onIntermediateImageSet(id, imageInfo);
            tvFrescoListener2.setText("IntermediateImageSet image receiced");
        }

        /*加载图片失败*/
        @Override
        public void onFailure(String id, Throwable throwable) {
            super.onFailure(id, throwable);
            tvFrescoListener.setText("Error loading" + id);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freso_listener);
        ButterKnife.bind(this);
        tvTitle.setText("图片加载监听");
    }

    @OnClick(R.id.bt_fresco_listener)
    public void onClick() {
        /*图片质量配置*/
        ProgressiveJpegConfig jpegConfig = new ProgressiveJpegConfig() {
            @Override
            public int getNextScanNumberToDecode(int scanNumber) {
                return scanNumber + 2;
            }


            /**/
            @Override
            public QualityInfo getQualityInfo(int scanNumber) {
                boolean isGoodEnough = (scanNumber >= 5);

                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
            }
        };
        /*图片地址*/
        Uri uri = Uri.parse("http://h.hiphotos.baidu.com/zhidao/pic/item/58ee3d6d55fbb2fbac4f2af24f4a20a44723dcee.jpg");
        /*图片请求*/
        ImageRequest request = ImageRequestBuilder
                .newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        /*图片加载的控制*/
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(sdvFrescoListener.getController())
                .setControllerListener(controllerListener)
                .build();
        /*加载图片*/
        sdvFrescoListener.setController(controller);

    }
}
