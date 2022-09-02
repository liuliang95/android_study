package com.example.mybroadcastdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver1 extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver1";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: MyBroadcastReceiver1");
    }
}
