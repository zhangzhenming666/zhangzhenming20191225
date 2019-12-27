package com.bawei.zhangzhenming20191225.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity {
    protected p  mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter = providePresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract p providePresenter();

    protected abstract int layoutId();
}
