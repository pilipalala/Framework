package com.example.administrator.demo.Framework.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.demo.R;

/*
* 获取属性的三种方式
* 1、用命名空间去获取
* 2、遍历属性集合
* 3、使用系统工具获取属性
* */
public class MyAttributeView extends View {
    private String myName;
    private int myAge;
    private Bitmap myBg;

    public MyAttributeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /*1、用命名空间去获取*/
        String my_name = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "my_name");
        String my_age = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "my_age");
        String my_bg = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "my_bg");
        /* 2、遍历属性集合*/
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            attrs.getAttributeName(i);
        }
        /*3、使用系统工具获取属性*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyAttributeView);
        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int index = typedArray.getIndex(i);
            switch (index) {
                case R.styleable.MyAttributeView_my_name:
                    myName = typedArray.getString(index);
                    break;
                case R.styleable.MyAttributeView_my_age:
                    //默认是0
                    myAge = typedArray.getInt(index, 0);
                    break;
                case R.styleable.MyAttributeView_my_bg:
                    Drawable drawable = typedArray.getDrawable(index);
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    myBg = bitmapDrawable.getBitmap();
                    break;
            }
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        canvas.drawText(myName + "---" + myAge,50,50,paint);
        canvas.drawBitmap(myBg, 60, 100, paint);
    }
}
