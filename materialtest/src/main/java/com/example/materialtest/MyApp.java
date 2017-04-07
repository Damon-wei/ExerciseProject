package com.example.materialtest;

import android.app.Application;
import android.content.Context;

/**
 * Created by Damon on 2017/4/6.
 * Description :
 */

public class MyApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        LogUtil.init();
        LogUtil.d("===================");
    }
    public static Context getContext(){
        return context;
    }
}
