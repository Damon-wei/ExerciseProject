package com.example.lbstest;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Damon on 2017/3/17.
 * Description :
 */

public class T {
    public T() {

    }
    public static void showShort(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
