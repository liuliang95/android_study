package com.example.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // 获取ConnectivityManager，该类用于管理网络连接
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 需要获取网络状态的权限
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isAvailable()) {
            Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
        }

    }
}
