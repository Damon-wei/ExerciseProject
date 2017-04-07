package com.example.materialtest;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Damon on 2017/4/6.
 * Description :
 */

public class LogUtil {
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;

    public static int level = VERBOSE;// log 等级，NOTHING 即为不打印 log
    public static final String TAG = "log";

    public static void init(){
        if (!isApkDebugable(MyApp.getContext())) {
            level = NOTHING;
        }
    }
    public static boolean isApkDebugable(Context context) {
        try {
            ApplicationInfo info= context.getApplicationInfo();
            Log.d("tag","======="+(info.flags & ApplicationInfo.FLAG_DEBUGGABLE));
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE)!=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //默认tag为log
    public static void v(String msg){
        if (level <= VERBOSE) {
            Log.v(TAG,msg);
        }
    }
    public static void d(String msg){
        if (level <= DEBUG) {
            Log.d(TAG,msg);
        }
    }
    public static void i(String msg){
        if (level <= INFO) {
            Log.i(TAG,msg);
        }
    }
    public static void w(String msg){
        if (level <= WARN) {
            Log.w(TAG,msg);
        }
    }
    public static void e(String msg){
        if (level <= ERROR) {
            Log.e(TAG,msg);
        }
    }



    //自定义tag
    public static void v(String tag,String msg){
        if (level <= VERBOSE) {
            Log.v(tag,msg);
        }
    }
    public static void d(String tag,String msg){
        if (level <= DEBUG) {
            Log.d(tag,msg);
        }
    }
    public static void i(String tag,String msg){
        if (level <= INFO) {
            Log.i(tag,msg);
        }
    }
    public static void w(String tag,String msg){
        if (level <= WARN) {
            Log.w(tag,msg);
        }
    }
    public static void e(String tag,String msg){
        if (level <= ERROR) {
            Log.e(tag,msg);
        }
    }
}
