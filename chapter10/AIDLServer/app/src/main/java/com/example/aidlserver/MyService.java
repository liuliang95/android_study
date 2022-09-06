package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.w(TAG, "onBind...");
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate...");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand...");
        return super.onStartCommand(intent, flags, startId);
    }

    class MyBinder extends IMyAIDLInterface.Stub {

        String name = "default";

        @Override
        public String getName() throws RemoteException {
            return "hello " + name;
        }

        @Override
        public void setName(String name) throws RemoteException {
            this.name = name;
        }
    }
}