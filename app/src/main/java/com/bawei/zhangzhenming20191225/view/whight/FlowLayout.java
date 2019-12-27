package com.bawei.zhangzhenming20191225.view.whight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.zhangzhenming20191225.R;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public class FlowLayout extends ViewGroup {
    int screenWidht;
    private int color;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        screenWidht = getResources().getDisplayMetrics().widthPixels;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlowLayoyt);
        color = typedArray.getColor(R.styleable.FlowLayoyt_myColor, Color.BLACK);
    }

    @Override
    protected void onLayout(boolean b, int l, int i1, int i2, int i3) {
        int wSapce = 20;
        int hSapce = 20;
        int left = wSapce;
        int top = hSapce;
        int right = 0;
        int bottom = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.measure(0, 0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();

            right = left + measuredWidth;
            if (right < measuredWidth) {
                bottom = top + measuredHeight;
            } else {
                left = wSapce;
                top = bottom + hSapce;
                right = left + measuredWidth;
                bottom = top + measuredHeight;
            }
            childAt.layout(left, top, right, bottom);


            left = right + wSapce;

        }
    }

    public void addTag(final String tag) {
        TextView textView = new TextView(getContext());
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTagClickListener != null) {
                    onTagClickListener.onTagClick(tag);
                }
            }
        });
        textView.setText(tag);
        textView.setTextSize(10);
        textView.setTextColor(color);
        textView.setBackgroundColor(Color.RED);
    }

    OnTagClickListener onTagClickListener;

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.onTagClickListener = onTagClickListener;
    }

    public interface OnTagClickListener {
        void onTagClick(String tag);
    }
}
