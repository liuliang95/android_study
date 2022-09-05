package com.example.sharedpreferencesdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ForceOfflineReceiver extends BroadcastReceiver {
    private static final String TAG = "ForceOfflineReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: force offline");
        Intent intent2 = new Intent(context, LoginActivity.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent2);

    }
}
