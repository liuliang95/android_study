package com.example.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ServiceTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void start_service(View view) {
        Log.i(TAG, "start_service...");
        startService(new Intent(this, FirstService.class));
    }

    public void stop_service(View view) {
        Log.i(TAG, "stop_service...");
        stopService(new Intent(this, FirstService.class));
    }
}