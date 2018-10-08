package com.fei.feilibs_1_0_0;

import android.app.Application;

import com.fei.feilibs_1_0_0.uncaughtexceptionhandler.MyExceptionHandler;

public abstract class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //开启程序错误时的错误信息保存
        MyExceptionHandler.create(this,setErrorLogPath());
    }

    /**
     * 设置程序报错后的错误信息存储路径
     * @return
     */
    protected abstract String setErrorLogPath();

}
