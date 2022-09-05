package com.example.filestoragedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.ed_edit)
    public EditText editData;

    @OnClick(R.id.submit)
    public void submit(){
        String data = editData.getText().toString();
        readData();
//        writeFile(data);
    }

    private void readData() {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fis = openFileInput("demo");
            br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while((line = br.readLine())!= null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.i(TAG, "readData: " + sb.toString());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    private void writeFile(String data) {
        BufferedWriter bw = null;
        try {
            FileOutputStream fileOutputStream = openFileOutput("demo", MODE_PRIVATE);
            bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}