package com.example.administrator.demo.Framework.materialdesign.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseFragment;
import com.example.administrator.demo.R;

/**
 * Created by Administrator on 2017/2/23.
 */
public class PaletteFragment extends BaseFragment {

    private static final int[] drawables = {R.mipmap.one, R.mipmap.two, R.mipmap.four, R.mipmap
            .three, R.mipmap.five};
    private static final String ARG_POSITION = "position";
    private int position;
    private FrameLayout frameLayout;
    private TextView textView;

    public static PaletteFragment newInstance(int position) {
        PaletteFragment frament = new PaletteFragment();

        /*通过bundle传递position*/
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_POSITION, position);
        frament.setArguments(bundle);

        return frament;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    protected View initView() {
        frameLayout = new FrameLayout(mContext);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        frameLayout.setLayoutParams(params);
        frameLayout.setBackgroundResource(drawables[position]);

        /*这个方法是转变为标准尺寸的一个函数，例如
        int size = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, context.getResources().getDisplayMetrics());
        这里COMPLEX_UNIT_SP是单位，20是数值，也就是20sp。*/
        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        params.setMargins(margin, margin, margin, margin);

        textView = new TextView(mContext);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.BOTTOM);
        textView.setTextColor(Color.WHITE);
        frameLayout.addView(textView);
        return frameLayout;
    }

    @Override
    protected void initData() {
        super.initData();
        textView.setText("CARD" + position);
    }



    /**
     * 提供当前Fragment的主色调的bitmap对象，供Palette解析颜色
     *
     * @param selectViewPagerItem
     * @return
     */
    public static int getBackgroundBitmapPosition(int selectViewPagerItem) {
        return drawables[selectViewPagerItem];
    }
}
