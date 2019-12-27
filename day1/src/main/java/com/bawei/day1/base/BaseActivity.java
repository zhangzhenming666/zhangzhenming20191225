package com.bawei.day1.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity {
    protected  p   mPewsenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPewsenter = providePresenter();
        if (mPewsenter != null) {
            mPewsenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract p providePresenter();

    protected abstract int layoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPewsenter != null) {
            mPewsenter.detach();
        }
    }

}
