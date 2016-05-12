package com.yan.mycustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Yan Gao on 5/12/16.
 */
public class MyCustomView extends View {
    private String customString;
    private float customLength;
    private int customColor;
    private TextPaint textPaint;
    private float textLenth;
    public MyCustomView(Context context) {
        super(context);
        init(null, 0);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, R.attr.CustomViewStyle);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }
    private void init(AttributeSet attrs, int defStyle) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView, defStyle, 0);
        customColor = array.getColor(R.styleable.MyCustomView_customColor, 0x00ff00);
        customLength = array.getDimension(R.styleable.MyCustomView_customLength, 1);
        customString = array.getString(R.styleable.MyCustomView_customString);
        array.recycle();
        textPaint = new TextPaint();
        textLenth = textPaint.measureText(customString);
        textPaint.setColor(customColor);
        textPaint.setTextSize(customLength);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(customString, getLeft(), getTop(), textPaint);
    }
}
