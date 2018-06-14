package com.example.lizah.imageserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageService extends Service {
    private int counter = 0;


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
        //requestPermission();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TcpClient tcpClient = new TcpClient(getPicsFilesList());
                    tcpClient.startCommunication();

                }catch (Exception ex) {


                }
        }}).start();


    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Image service stopped...", Toast.LENGTH_LONG).show();
    }

    public void getJPG(File e, List<File> picsFilesList) {
        File[] dirFiles = e.listFiles();
        for (int i=0; i <dirFiles.length; i++) {
            if (dirFiles[i].isDirectory()) {
                getJPG(dirFiles[i], picsFilesList);
            } else if(dirFiles[i].toString().contains(".jpg")) {
                picsFilesList.add(dirFiles[i]);
            }
        }
    }

    public List<File> getPicsFilesList() {
        File dcim = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if (dcim == null) {
            return null;
        }
        File[] pics = dcim.listFiles();
        List<File> picsFilesList = new ArrayList<File>();
        if (pics != null) {
            for (int i=0; i <pics.length; i++) {
                if (pics[i].isDirectory()) {
                    getJPG(pics[i], picsFilesList);
                } else if(pics[i].toString().contains(".jpg")) {
                    picsFilesList.add(pics[i]);
                }
            }
        }

        return picsFilesList;
    }

}
