package com.example.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FourActivity extends AppCompatActivity {
    private static final String TAG = "FourActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        Button btn = findViewById(R.id.skip5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String data = "hello 5";
                Intent intent = new Intent(FourActivity.this, FiveActivity.class);
//                intent.putExtra("data", data);
//                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    String t = data.getStringExtra("data_return");
                    Log.i(TAG, t);
                }
        }
    }
}
