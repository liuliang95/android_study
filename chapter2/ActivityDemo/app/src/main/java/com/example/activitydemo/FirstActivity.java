package com.example.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btn = findViewById(R.id.toSecond);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(this, SecondActivity.class);
        Intent intent = new Intent("com.example.activitydemo.ACTION_START");
        intent.addCategory("com.example.activitydemo.MY_CATEGORY");
        startActivity(intent);
    }
}
