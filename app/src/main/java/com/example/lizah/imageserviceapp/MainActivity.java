package com.example.lizah.imageserviceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {




       Intent intent = new Intent(this, ImageService.class);
       startService(intent);

       /* Integer notificationID = 100;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//Set notification information:
        Notification.Builder notificationBuilder = new Notification.Builder(getApplicationContext());
        notificationBuilder.setOngoing(true)
                .setContentTitle(new String("Notification Content Title"))
                .setContentText(new String("Notification Content Text"))
                .setProgress(100, 0, false);

//Send the notification:
        Notification notification;
       *//* notification = notificationBuilder.build();
        notificationManager.notify(notificationID, notification);*//*

        if (Build.VERSION.SDK_INT < 16) {
            notificationManager.notify(notificationID, notificationBuilder.getNotification());
        } else {
            notificationManager.notify(notificationID, notificationBuilder.build());
        }*/

     /*   final NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"hjh");
        final int notify_id = 1;
        final NotificationManager NM = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Passing images...");
        builder.setContentText("Passing in progress...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<=100; i+=5) {
                    builder.setProgress(100,i,false);
                    NM.notify(notify_id,builder.build());
                    try {
                        Thread.sleep(2*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                builder.setProgress(0,0,false);
                builder.setContentText("Passing completed!");
                NM.notify(notify_id,builder.build());
            }
        }).start();*/

    }
    public void stopService(View  view) {
        Intent intent = new Intent(this, ImageService.class);
        stopService(intent);
    }
}
