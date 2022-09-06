package com.example.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aidlserver.IMyAIDLInterface;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private boolean isBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindRemoteService();
        Button btn = findViewById(R.id.bind_service_btn);
        EditText ed_name = findViewById(R.id.et_name);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBind && iMyAIDLInterface != null) {
                    try {
                        iMyAIDLInterface.setName(ed_name.getText().toString());
                        String name = iMyAIDLInterface.getName();
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private IMyAIDLInterface iMyAIDLInterface;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAIDLInterface = IMyAIDLInterface.Stub.asInterface(service);
            Log.i(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            if(isBind && iMyAIDLInterface != null) {
                iMyAIDLInterface = null;
            }
        }
    };

    private void bindRemoteService() {
        Intent intent = new Intent();
        intent.setAction("com.example.aidlserver.MyService");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage("com.example.aidlserver");
        isBind = bindService(intent, conn, BIND_AUTO_CREATE);
    }
}