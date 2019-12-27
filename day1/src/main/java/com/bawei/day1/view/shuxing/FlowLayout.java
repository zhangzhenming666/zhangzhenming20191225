package com.bawei.day1.view.shuxing;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.day1.R;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public class FlowLayout extends ViewGroup {

    int widthPixel;
    private int color;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        widthPixel = displayMetrics.widthPixels;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        color = typedArray.getColor(R.styleable.FlowLayout_myColor, Color.BLACK);
    }

    @Override
    protected void onLayout(boolean b, int l, int i1, int i2, int i3) {
        int wSpace = 30;
        int hSpace = 20;
        int left = wSpace;
        int top = hSpace;
        int right = 0;
        int bottom = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            right = left + measuredWidth;
            if (right<widthPixel){
                bottom = top + measuredHeight;
            }else {
                left = 0+wSpace;
                top = bottom + hSpace;
                right = left + measuredWidth;
                bottom = top + measuredHeight;
            }
            childAt.layout(left,top,right,bottom);
            left = right + wSpace;
        }
    }

    public void addTag(final String tag){
        TextView textView = new TextView(getContext());
        textView.setText(tag);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onTagClickListener.OnTagClick(tag);
            }
        });
        textView.setTextColor(color);
        textView.setBackgroundColor(Color.YELLOW);
        addView(textView);
    }

    OnTagClickListener onTagClickListener;

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.onTagClickListener = onTagClickListener;
    }

    public interface OnTagClickListener{
        void OnTagClick(String tag);
    }
}
