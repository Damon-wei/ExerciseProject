package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    private OffLineRecriver offLineRecriver;
    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("offline");
        localBroadcastManager = LocalBroadcastManager.getInstance(BaseActivity.this);
        offLineRecriver = new OffLineRecriver();
        localBroadcastManager.registerReceiver(offLineRecriver,intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityTools.addAct(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offLineRecriver != null) {
            localBroadcastManager.unregisterReceiver(offLineRecriver);
            offLineRecriver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityTools.removeAct(this);
    }
    class OffLineRecriver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            ActivityTools.finishAll();
            startActivity(new Intent(context,LoginActivity.class));
        }
    }
}
