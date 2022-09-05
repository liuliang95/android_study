package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @OnClick(R.id.store_btn)
    public void storeClick(){
        Log.i(TAG, "storeClick: OK");
//        SharedPreferences sharedPreferences= getPreferences(MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", "Tom");
        editor.putInt("age", 28);
        editor.putBoolean("married", false);
        editor.apply();
    }

    @OnClick(R.id.read_btn)
    public void readClick(){
        Log.i(TAG, "readClick: OK");
        SharedPreferences sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);
        // 第二个参数是默认值，防止没有该键
        String name = sharedPreferences.getString("name", "");
        int age = sharedPreferences.getInt("age", 0);
        boolean married = sharedPreferences.getBoolean("married", false);
        
        Log.i(TAG, "readClick: name ===> " + name);
        Log.i(TAG, "readClick: age ===> " + age);
        Log.i(TAG, "readClick: married ===> " + married);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}