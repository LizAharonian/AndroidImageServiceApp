package com.example.lizah.imageserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    /**
     * onCreate function.
     * define what happens when action is created.
     * @param savedInstanceState - Bundle obj.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * startService function.
     * defines what happens when user clicks the start btn.
     * @param view - View obj.
     */
    public void startService(View view) {

       Intent intent = new Intent(this, ImageService.class);
       startService(intent);

    }

    /**
     * stopService function.
     * defines what happens when user press the stop btn.
     * @param view
     */
    public void stopService(View  view) {
        Intent intent = new Intent(this, ImageService.class);
        stopService(intent);
    }
}
