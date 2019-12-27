package com.bawei.zhangzhenming20191225.util;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public class MyCaught implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        Log.e("TAG", "捕获异常: "+throwable.getMessage());
    }
}
