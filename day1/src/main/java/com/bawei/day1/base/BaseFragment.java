package com.bawei.day1.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        mPresenter = providerPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initView(inflate);
        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract P providerPresenter();

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}
