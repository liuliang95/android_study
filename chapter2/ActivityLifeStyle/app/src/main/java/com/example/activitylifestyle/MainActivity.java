package com.example.activitylifestyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            String res = savedInstanceState.getString("data_key");
            Log.i(TAG, res);
        } else {
            Log.i(TAG, "savedInstanceState is null");
        }

        Button normalBtn = findViewById(R.id.start_normal_activity);
        Button dialogBtn = findViewById(R.id.start_dialog_activity);

        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart...");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume...");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause...");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop...");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy...");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart...");
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Log.i(TAG, "onSaveInstanceState...");
        String tempData = "something you want to save";
        bundle.putString("data_key", tempData);
    }
}