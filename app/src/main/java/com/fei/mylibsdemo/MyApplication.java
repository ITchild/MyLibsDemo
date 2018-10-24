package com.fei.mylibsdemo;

import android.os.Environment;

import com.fei.feilibs_1_0_0.BaseApplication;
import com.fei.feilibs_1_0_0.utils.Utils;

public class MyApplication extends BaseApplication {
    private static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Utils.init(app);
    }

    @Override
    protected String setErrorLogPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+getPackageName();
    }
}
