package com.example.administrator.demo.Framework.fresco.activity;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FresoGifActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.sdv_fresco_gif)
    SimpleDraweeView sdvFrescoGif;
    @Bind(R.id.bt_fresco_askImg)
    Button btFrescoAskImg;
    @Bind(R.id.bt_fresco_stopAnim)
    Button btFrescoStopAnim;
    @Bind(R.id.bt_fresco_startAnim)
    Button btFrescoStartAnim;
    Animatable animatable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freso_gif);
        ButterKnife.bind(this);
        tvTitle.setText("Gif动画图片");
    }

    @OnClick({R.id.bt_fresco_askImg, R.id.bt_fresco_stopAnim, R.id.bt_fresco_startAnim})
    public void onClick(View view) {
        switch (view.getId()) {
            /*请求Gif图片*/
            case R.id.bt_fresco_askImg:
                // 图片地址
                Uri uri = Uri.parse("http://www.sznews.com/humor/attachement/gif/site3/20140902/4487fcd7fc66156f51db5d.gif");
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(false)//自动播放
                        .setOldController(sdvFrescoGif.getController())
                        .build();

                // 设置控制器
                sdvFrescoGif.setController(controller);
                break;
            /*动画停止*/
            case R.id.bt_fresco_stopAnim:
                animatable = sdvFrescoGif.getController().getAnimatable();
                if (animatable != null && animatable.isRunning()) {
                    animatable.stop();
                }
                break;
            /*动画开始*/
            case R.id.bt_fresco_startAnim:

                animatable = sdvFrescoGif.getController().getAnimatable();
                if (animatable != null && !animatable.isRunning()) {
                    animatable.start();
                }
                break;
        }
    }
}
