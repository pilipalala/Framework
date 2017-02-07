package com.example.administrator.demo.Framework.glide.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.administrator.demo.Framework.glide.Utils;
import com.example.administrator.demo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

/**
 * Created by Administrator on 2017/1/6.
 */
public class GlideTranfromationsAdapter extends RecyclerView.Adapter<GlideTranfromationsAdapter.MyViewHolder> {
    private final Context mContext;
    private final ArrayList<Integer> mData = new ArrayList<>();
    private int integer;

    public GlideTranfromationsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.glide_recycleview_adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvGlideName.setText("item"+(position+1));
        switch (position+1) {
            case 1: {
                int width = Utils.dip2px(mContext, 133.33f);
                int height = Utils.dip2px(mContext, 126.33f);
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .override(width, height)
                        .bitmapTransform(new CenterCrop(mContext),
                                new MaskTransformation(mContext, R.mipmap.mask_starfish))
                        .into(holder.ivImageview);
                break;
            }
            case 2: {
                int width = Utils.dip2px(mContext, 150.0f);
                int height = Utils.dip2px(mContext, 100.0f);
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .override(width, height)
                        .bitmapTransform(new CenterCrop(mContext),
                                new MaskTransformation(mContext, R.drawable.mask_chat_right))
                        .into(holder.ivImageview);
                break;
            }
            case 3:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(
                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.TOP))
                        .into(holder.ivImageview);
                break;
            case 4:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(new CropTransformation(mContext, 300, 100))
                        .into(holder.ivImageview);
                break;
            case 5:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(
                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.BOTTOM))
                        .into(holder.ivImageview);

                break;
            case 6:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(new CropSquareTransformation(mContext))
                        .into(holder.ivImageview);
                break;
            case 7:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(new CropCircleTransformation(mContext))
                        .into(holder.ivImageview);
                break;
            case 8:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(new ColorFilterTransformation(mContext, Color.argb(80, 255, 0, 0)))
                        .into(holder.ivImageview);
                break;
            case 9:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(new GrayscaleTransformation(mContext))
                        .into(holder.ivImageview);
                break;
            case 10:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(new RoundedCornersTransformation(mContext, 30, 0,
                                RoundedCornersTransformation.CornerType.BOTTOM))
                        .into(holder.ivImageview);
                break;
            case 11:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new BlurTransformation(mContext, 25))
                        .into(holder.ivImageview);
                break;
            case 12:
                Glide.with(mContext)
                        .load(R.mipmap.demo)
                        .bitmapTransform(new ToonFilterTransformation(mContext))
                        .into(holder.ivImageview);
                break;
            case 13:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new SepiaFilterTransformation(mContext))
                        .into(holder.ivImageview);
                break;
            case 14:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new ContrastFilterTransformation(mContext, 2.0f))
                        .into(holder.ivImageview);
                break;
            case 15:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new InvertFilterTransformation(mContext))
                        .into(holder.ivImageview);
                break;
            case 16:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new PixelationFilterTransformation(mContext, 20))
                        .into(holder.ivImageview);
                break;
            case 17:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new SketchFilterTransformation(mContext))
                        .into(holder.ivImageview);
                break;
            case 18:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(
                                new SwirlFilterTransformation(mContext, 0.5f, 1.0f, new PointF(0.5f, 0.5f)))
                        .into(holder.ivImageview);
                break;
            case 19:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new BrightnessFilterTransformation(mContext, 0.5f))
                        .into(holder.ivImageview);
                break;
            case 20:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new KuwaharaFilterTransformation(mContext, 25))
                        .into(holder.ivImageview);
                break;
            case 21:
                Glide.with(mContext)
                        .load(R.mipmap.check)
                        .bitmapTransform(new VignetteFilterTransformation(mContext, new PointF(0.5f, 0.5f),
                                new float[] { 0.0f, 0.0f, 0.0f }, 0f, 0.75f))
                        .into(holder.ivImageview);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 21;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_imageview)
        ImageView ivImageview;
        @Bind(R.id.tv_glide_name)
        TextView tvGlideName;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}
