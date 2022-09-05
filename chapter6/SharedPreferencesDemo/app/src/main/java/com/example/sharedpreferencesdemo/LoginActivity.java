package com.example.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.et_account)
    public EditText etAccount;

    @BindView(R.id.et_password)
    public EditText etPassword;

    @BindView(R.id.cb_isRemember)
    public CheckBox cbisRemember;
    private SharedPreferences sharedPreferences;

    @OnClick(R.id.btn_login)
    public void login() {
        String account = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        boolean checked = cbisRemember.isChecked();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if("admin".equals(account) && "123456".equals(password)) {
            // 如果点击了复选框
            if(checked) {
                editor.putString("account", account);
                editor.putString("password", password);
                editor.putBoolean("checked", true);
            } else {
                editor.clear();
            }
            // 提交数据
            editor.apply();
            // 跳转页面
            Intent intent = new Intent(LoginActivity.this, SuccessActivity.class);
            startActivity(intent);
            finish();
        } else {
            // 登录失败
            Toast.makeText(this, "account or password is not valid", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean checked = sharedPreferences.getBoolean("checked", false);
        if(checked) {
            String account = sharedPreferences.getString("account", "");
            String password = sharedPreferences.getString("password", "");
            etAccount.setText(account);
            etPassword.setText(password);
            cbisRemember.setChecked(checked);
        }
    }
}
