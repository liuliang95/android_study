package com.example.myprovidertest;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private String newId;
    private static final String TAG = "MainActivity";

    @OnClick(R.id.add_data)
    public void add() {
        Uri uri = Uri.parse("content://com.example.contentproviderdemo.provider/book");
        ContentValues values = new ContentValues();
        values.put("name", "A Clash of Kings");
        values.put("author", "George Martin");
        values.put("pages", 1040);
        values.put("price", 22.85);
        Uri newUri = getContentResolver().insert(uri, values);
        newId = newUri.getPathSegments().get(1);
        Log.i(TAG, "add: " + newId);
    }

    @OnClick(R.id.delete_data)
    public void delete() {
        Uri uri = Uri.parse("content://com.example.contentproviderdemo.provider/book/1");
        int delete = getContentResolver().delete(uri, null, null);
        Log.i(TAG, "delete " + ((delete > 0)? "success": "failure"));
    }

    @OnClick(R.id.update_data)
    public void update() {
        Uri uri = Uri.parse("content://com.example.contentproviderdemo.provider/book/2");
        ContentValues values = new ContentValues();
        values.put("name", "A Storm of Swords");
        values.put("pages", 1216);
        values.put("price", 24.05);
        int update = getContentResolver().update(uri, values, null, null);
        Log.i(TAG, "update " + ((update > 0)? "success": "failure"));
    }

    @OnClick(R.id.query_data)
    @SuppressLint("Range")
    public void query() {
        Log.i(TAG, "query ...");
        Uri uri = Uri.parse("content://com.example.contentproviderdemo.provider/book/");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//        Log.i(TAG, "query: " + cursor.getCount());
        Log.i(TAG, cursor+"");
        if(cursor != null) {
            while(cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double prices = cursor.getDouble(cursor.getColumnIndex("price"));
                Book book = new Book(id, name, author, pages, prices);
                Log.i(TAG, book.toString());
            }
            cursor.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}