package com.bawei.zhangzhenming20191225.base;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public abstract class BasePresenter<V> {
    protected V view;

    public void attach(V view) {
        this.view = view;
    }
    public void detach(){
        view =null;
    }

    public BasePresenter() {
        initModeel();
    }

    protected abstract void initModeel();
}
