package com.bawei.zhangzhenming20191225;

import android.app.Application;

import com.bawei.zhangzhenming20191225.util.MyCaught;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public class App extends Application {
    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

     // Thread.setDefaultUncaughtExceptionHandler(new MyCaught());
    }
}
