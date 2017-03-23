package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.renderscript.RenderScript;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.max;
import static android.R.string.no;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(this);

    }

    private void sendNotification() {
        Intent intent = new Intent(MainActivity.this,OtherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        NotificationManager notificationManagerCompat = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(MainActivity.this)
                .setContentTitle("Android")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentText("You hava a new message form Android")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("compile 'com.android.support:appcompat-v7:25.2.0'\n" +
                        "    compile 'com.android.support.constraint:constraint-layout:1.0.0-alpha8'\n" +
                        "    testCompile 'junit:junit:4.12'\n" +
                        "    compile 'org.litepal.android:core:1.5.0'"))
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.logo1)))
                .setContentIntent(pendingIntent)
                .build();
        notificationManagerCompat.notify(1,notification);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                sendNotification();
                break;
            default:
        }
    }
}
