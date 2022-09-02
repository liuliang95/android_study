package com.example.mybroadcastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyBroadcastReceiver receiver;

    @OnClick(R.id.standard_broadcast) void click1(){
        Intent intent = new Intent();
        intent.setAction("com.example.broadcastdemo.My_BROADCAST");
        intent.putExtra("data", "hello, receiver");
        sendBroadcast(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcastdemo.My_BROADCAST");
        receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}