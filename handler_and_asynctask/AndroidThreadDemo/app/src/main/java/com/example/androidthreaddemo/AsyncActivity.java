package com.example.androidthreaddemo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AsyncActivity extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    public ProgressBar progressBar;

    @BindView(R.id.progress_text)
    public TextView progressText;

    @OnClick(R.id.submit)
    public void download(){
        // 启动下载任务
        new DownloadTask().execute();
    }

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        ButterKnife.bind(this);
        mContext = this;
    }


    class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
        private static final String TAG = "DownloadTask";

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute: xxx");
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            Log.i(TAG, "doInBackground: xxx");
            try {
                while(true) {
                    int progress = 0;
                    for (int i=0;i<=10;i++) {
                        progress = (int)(i / 10.0 * 100);
                        Thread.sleep(1000);
                        publishProgress(progress);
                    }
                    if(progress >= 100) break;
                }
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "onProgressUpdate: xxx");
            progressBar.setProgress(values[0]);
            progressText.setText(values[0] + "%");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            Log.i(TAG, "onPostExecute: xxx");
            if(aBoolean) {
                Toast.makeText(mContext, "Download Succeeded", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(mContext, "Download Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
