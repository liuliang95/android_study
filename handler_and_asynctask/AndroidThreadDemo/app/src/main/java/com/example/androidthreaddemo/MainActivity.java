package com.example.androidthreaddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: xxxx");
                test3();
            }
        });
    }

    private void test1() {
        new MyThread().start();
    }

    private void test2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.i(TAG, "run: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void test3(){
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(10000);
                return 1;
            }
        });
        Log.i(TAG, "test3: before run");
        task.run(); // 会阻塞住该线程
        Log.i(TAG, "test3: after run");
        try {
            Integer result = task.get();
            Log.i(TAG, "test3: " + result);
        }  catch (Exception e) {
            e.printStackTrace();
        }


    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                Log.i(TAG, "run: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}