package com.bawei.day1;

import android.app.Application;

/**
 * 时间：2019/12/26
 * 作者：张振明
 * 类的作用：
 */
public class App extends Application {
    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
