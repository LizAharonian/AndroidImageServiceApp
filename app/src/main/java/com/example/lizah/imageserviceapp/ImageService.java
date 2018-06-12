package com.example.lizah.imageserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class ImageService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {
        Toast.makeText(this, "Image service started...", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    @Override
    public void onCreate() {
        super.onCreate();

    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Image service stopped...", Toast.LENGTH_LONG).show();
    }

}
