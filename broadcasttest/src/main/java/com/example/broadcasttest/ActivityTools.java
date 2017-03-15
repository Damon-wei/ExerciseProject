package com.example.broadcasttest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damon on 2017/3/14.
 * Description :
 */

public class ActivityTools {
    public static List<Activity> activityList = new ArrayList<>();
    public static void addAct(Activity activity){
        activityList.add(activity);
    }
    public static void removeAct(Activity activity){
        activityList.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity:activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
