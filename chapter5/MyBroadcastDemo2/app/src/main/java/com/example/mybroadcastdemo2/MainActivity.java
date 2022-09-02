package com.example.mybroadcastdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver1 receiver1;
    private MyBroadcastReceiver2 receiver2;

    @OnClick(R.id.send)
    public void send(){
        Intent intent = new Intent("com.example.MY_BROADCAST2");
//        sendBroadcast(intent);
        sendOrderedBroadcast(intent, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("com.example.MY_BROADCAST2");
        intentFilter1.setPriority(10);
        receiver1 = new MyBroadcastReceiver1();
        registerReceiver(receiver1, intentFilter1);
        //#############################################################
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.example.MY_BROADCAST2");
        intentFilter2.setPriority(20);
        receiver2 = new MyBroadcastReceiver2();
        registerReceiver(receiver2, intentFilter2);
    }
}