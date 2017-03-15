package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {


    private Button btn_offline;
    private NetWorkChangeReceiver receiver;
    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_offline = (Button) findViewById(R.id.btn_offline);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
         receiver = new NetWorkChangeReceiver();
        registerReceiver(receiver,intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        btn_offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("offline");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    class NetWorkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager systemService = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = systemService.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isAvailable()) {
                Toast.makeText(MainActivity.this,"网络已连接",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this,"网络已断开",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
