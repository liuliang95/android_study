package com.example.activitymode;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class NewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        LinearLayout layout = findViewById(R.id.linear_layout);
        Random random = new Random();
        int colorValue = random.nextInt();
        layout.setBackgroundColor(colorValue);
    }
}
