package com.bawei.day1.base;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public abstract class BasePresenter<V> {
    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
