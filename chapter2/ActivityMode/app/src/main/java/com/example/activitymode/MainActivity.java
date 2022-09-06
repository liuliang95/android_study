package com.example.activitymode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (time < 5) {
                    startActivity(new Intent(MainActivity.this, NewActivity.class));
                    Log.i(TAG, "start new activity...");
                    time++;
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }
}