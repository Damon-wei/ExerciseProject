package com.example.lbstest;

import android.util.Log;

/**
 * Created by Damon on 2017/3/16.
 * Description :
 */

public class L {
    public L() {
    }

    private static boolean isDebug = true;
    private static String tag = "damon";
    public static void d(String string){
        if (isDebug) {
            Log.d(tag,string);
        }
    }
}
