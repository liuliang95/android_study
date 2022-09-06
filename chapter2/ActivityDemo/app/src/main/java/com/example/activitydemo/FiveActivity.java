package com.example.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        TextView tv=  findViewById(R.id.tv_data_5);
        tv.setText(data);
        Button btn = findViewById(R.id.skip4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_return = new Intent();
                intent_return.putExtra("data_return", "hello");
                setResult(RESULT_OK, intent_return);
                finish();
            }
        });
    }
}
