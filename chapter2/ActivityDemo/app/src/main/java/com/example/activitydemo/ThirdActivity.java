package com.example.activitydemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btn = findViewById(R.id.skipBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW); // Display the data to the user.
                Intent intent = new Intent(Intent.ACTION_DIAL); // Dial a number as specified by the data.

//                intent.setData(Uri.parse("http://www.baidu.com"));
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }
}
