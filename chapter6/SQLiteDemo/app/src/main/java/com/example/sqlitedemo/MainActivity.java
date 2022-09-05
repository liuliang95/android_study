package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase writableDatabase;
    private SQLiteDatabase readableDatabase;
    private static final String TAG = "MainActivity";

    @OnClick(R.id.btn_create)
    public void createClick() {

    }

    @OnClick(R.id.btn_add)
    public void addClick() {
        ContentValues cv = new ContentValues();
        cv.put("name", "The Da Vinci Code");
        cv.put("author", "Dan Brown");
        cv.put("pages", 454);
        cv.put("price", 16.96);
        writableDatabase.insert("Book", null, cv);
        Toast.makeText(this, "add success", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_query)
    @SuppressLint("Range")
    public void queryClick() {
        Cursor cursor = readableDatabase.query("Book", new String[]{"id", "name", "author", "pages", "price"}
                , "name = ?", new String[]{"The Da Vinci Code"}, null, null, null);
        int count = cursor.getCount();
        Log.i(TAG, "count ==> " + count);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String author = cursor.getString(cursor.getColumnIndex("author"));
            Log.i(TAG, "id ===> " + id);
            Log.i(TAG, "name ===> " + name);
            Log.i(TAG, "author ===> " + author);
        }
    }

    public void exec() {
        // 增加数据
        writableDatabase.execSQL("insert into Book(name, author, pages, price) values(?,?,?,?)",
                new String[]{"The Da Vinci Code", "Dan Brown", "454", "16.69"});
        // 删除数据
        writableDatabase.execSQL("delete from Book where pages > ?", new String[]{"500"});
        // 修改数据
        writableDatabase.execSQL("update Book set price = ? where name = ?", new String[]{"10.99", "The Da Vinci Code"});
        // 查询数据
        readableDatabase.execSQL("select * from Book where id = ?", new String[]{"1"});
    }

    @OnClick(R.id.btn_delete)
    public void deleteClick() {
        writableDatabase.delete("Book", "id = ?", new String[]{"3"});
    }

    @OnClick(R.id.btn_update)
    public void updateClick() {
        ContentValues cv = new ContentValues();
        cv.put("name", "The Lost Symbol");
        cv.put("author", "Dan Brown");
        cv.put("pages", 510);
        cv.put("price", 19.95);
        writableDatabase.update("Book", cv, "id = ?", new String[]{"2"});
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        writableDatabase = dbHelper.getWritableDatabase();
        readableDatabase = dbHelper.getReadableDatabase();
    }
}