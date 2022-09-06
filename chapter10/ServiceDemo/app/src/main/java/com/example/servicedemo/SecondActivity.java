package com.example.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private SecondService.CommunicateBinder communicateBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected...");
            communicateBinder = (SecondService.CommunicateBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected...");
            if(communicateBinder != null) communicateBinder = null;
        }
    };

    public void bindService(View view) {
        Intent intent = new Intent(this, SecondService.class);
        //第一个是参数是意图对象,第二个参数是回调,第三个参数是标记,这个是自动创建的意,如果服务没有start,那么会自己创建。
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        if(conn != null) {
            unbindService(conn);
        }
    }

    public void call(View view) {
        if(communicateBinder != null) {
            communicateBinder.call();
        }

    }
}
