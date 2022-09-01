package com.example.uidemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("this is a dialog"); // 标题
                dialog.setMessage("Something important"); // 消息内容
                dialog.setCancelable(true); // 可否取消，感觉没啥用
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() { //点击确定的回调
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "OK");
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { //点击取消的回调
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "Cancel");
                    }
                });
                dialog.show();
            }
        });


    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_alertdialog);
//
//        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//                progressDialog.setTitle("this is a progressDialog");
//                progressDialog.setMessage("Loading...");
//                progressDialog.setCancelable(false); // 这个有点用，如果为false就
//                progressDialog.show();
//
//            }
//        });
//
//
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_progressbar);
//
//        ProgressBar progressBar = findViewById(R.id.progress_bar);
//        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(progressBar.getVisibility() == View.VISIBLE) {
//                    progressBar.setVisibility(View.GONE);
//                } else {
//                    progressBar.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edittext);
//        Button btn = findViewById(R.id.btn);
//        EditText et = findViewById(R.id.edit_text);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, et.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_button);
//        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
}