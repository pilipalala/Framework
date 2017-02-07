package com.example.administrator.demo.Framework.picasso.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.glide.Utils;
import com.example.administrator.demo.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;
import jp.wasabeef.picasso.transformations.MaskTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import jp.wasabeef.picasso.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.VignetteFilterTransformation;

/**
 * Created by Administrator on 2017/1/8.
 */

public class PicassoTranfromationsAdapter extends BaseAdapter {

    private final Context mContext;

    public PicassoTranfromationsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 36;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PicassoViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_picasso_listview, null);
            holder = new PicassoViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (PicassoViewHolder) view.getTag();
        }
        /*显示名称*/
        holder.tvPicasso.setText("item" + (i + 1));
        /*加载图片*/

        initTranfromations(i, holder);
        return view;
    }

    private void initTranfromations(int i, PicassoViewHolder holder) {
        switch (i + 1) {
            case 1: {
                int width = Utils.dip2px(mContext, 133.33f);
                int height = Utils.dip2px(mContext, 126.33f);
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .resize(width, height)
                        .centerCrop()
                        .transform((new MaskTransformation(mContext, R.mipmap.mask_starfish)))
                        .into(holder.ivPicasso);
                break;
            }
            case 2: {
                int width = Utils.dip2px(mContext, 150.0f);
                int height = Utils.dip2px(mContext, 100.0f);
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .resize(width, height)
                        .placeholder(R.mipmap.atguigu_logo)
                        .centerCrop()
                        .transform(new MaskTransformation(mContext, R.drawable.chat_me_mask))
                        .into(holder.ivPicasso);
                break;
            }
            case 3:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.LEFT,
                                CropTransformation.GravityVertical.TOP))
                        .into(holder.ivPicasso);
                break;
            case 4:
                Picasso.with(mContext).load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                                // 300, 100, CropTransformation.GravityHorizontal.LEFT, CropTransformation.GravityVertical.CENTER))
                        .transform(new CropTransformation(300, 100)).into(holder.ivPicasso);
                break;
            case 5:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.LEFT,
                                CropTransformation.GravityVertical.BOTTOM))
                        .into(holder.ivPicasso);
                break;
            case 6:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.TOP))
                        .into(holder.ivPicasso);
                break;
            case 7:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(300, 100))
                        .into(holder.ivPicasso);
                break;
            case 8:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.BOTTOM))
                        .placeholder(R.mipmap.atguigu_logo)
                        .into(holder.ivPicasso);
                break;
            case 9:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.RIGHT,
                                CropTransformation.GravityVertical.TOP))
                        .into(holder.ivPicasso);
                break;
            case 10:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.RIGHT,
                                CropTransformation.GravityVertical.CENTER))
                        .into(holder.ivPicasso);
                break;
            case 11:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(300, 100, CropTransformation.GravityHorizontal.RIGHT,
                                CropTransformation.GravityVertical.BOTTOM))
                        .into(holder.ivPicasso);
                break;
            case 12:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation((float) 16 / (float) 9,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(holder.ivPicasso);
                break;
            case 13:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation((float) 4 / (float) 3,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(holder.ivPicasso);
                break;
            case 14:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(3, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(holder.ivPicasso);
                break;
            case 15:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(3, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.TOP))
                        .into(holder.ivPicasso);
                break;
            case 16:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation(1, CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(holder.ivPicasso);
                break;
            case 17:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation((float) 0.5, (float) 0.5,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(holder.ivPicasso);
                break;
            case 18:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation((float) 0.5, (float) 0.5,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.TOP))
                        .into(holder.ivPicasso);
                break;
            case 19:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation((float) 0.5, (float) 0.5,
                                CropTransformation.GravityHorizontal.RIGHT,
                                CropTransformation.GravityVertical.BOTTOM))
                        .into(holder.ivPicasso);
                break;
            case 20:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropTransformation((float) 0.5, 0, (float) 4 / (float) 3,
                                CropTransformation.GravityHorizontal.CENTER,
                                CropTransformation.GravityVertical.CENTER))
                        .into(holder.ivPicasso);
                break;
            case 21:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropSquareTransformation())
                        .into(holder.ivPicasso);
                break;
            case 22:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new CropCircleTransformation())
                        .into(holder.ivPicasso);
                break;
            case 23:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new ColorFilterTransformation(Color.argb(80, 255, 0, 0)))
                        .into(holder.ivPicasso);
                break;
            case 24:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new GrayscaleTransformation())
                        .into(holder.ivPicasso);
                break;
            case 25:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new RoundedCornersTransformation(30, 0,
                                RoundedCornersTransformation.CornerType.BOTTOM_LEFT))
                        .into(holder.ivPicasso);
                break;
            case 26:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new BlurTransformation(mContext, 25, 1))
                        .into(holder.ivPicasso);
                break;
            case 27:
                Picasso.with(mContext)
                        .load(R.mipmap.demo)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new ToonFilterTransformation(mContext))
                        .into(holder.ivPicasso);
                break;
            case 28:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new SepiaFilterTransformation(mContext))
                        .into(holder.ivPicasso);
                break;
            case 29:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new ContrastFilterTransformation(mContext, 2.0f))
                        .into(holder.ivPicasso);
                break;
            case 30:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new InvertFilterTransformation(mContext))
                        .into(holder.ivPicasso);
                break;
            case 31:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new PixelationFilterTransformation(mContext, 20))
                        .into(holder.ivPicasso);
                break;
            case 32:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new SketchFilterTransformation(mContext))
                        .into(holder.ivPicasso);
                break;
            case 33:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new SwirlFilterTransformation(mContext, 0.5f, 1.0f, new PointF(0.5f, 0.5f)))
                        .into(holder.ivPicasso);

                break;
            case 34:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new BrightnessFilterTransformation(mContext, 0.5f))
                        .into(holder.ivPicasso);
                break;
            case 35:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new KuwaharaFilterTransformation(mContext, 25))
                        .into(holder.ivPicasso);
                break;
            case 36:
                Picasso.with(mContext)
                        .load(R.mipmap.check)
                        .placeholder(R.mipmap.atguigu_logo)
                        .transform(new VignetteFilterTransformation(mContext, new PointF(0.5f, 0.5f),
                                new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f))
                        .into(holder.ivPicasso);
                break;
        }
    }

    static class PicassoViewHolder {
        @Bind(R.id.iv_picasso)
        ImageView ivPicasso;
        @Bind(R.id.tv_picasso)
        TextView tvPicasso;

        PicassoViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
