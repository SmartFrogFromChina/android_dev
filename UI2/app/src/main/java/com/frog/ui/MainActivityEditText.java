package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.frog.ui.Util.ToastUtil;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivityEditText extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button mBtnLogin;
        EditText mEtUsername,mEtPassword;
        TextView mTextViewNoAcount;

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_edit_text);
        mBtnLogin = findViewById(R.id.btn_login);
        mEtUsername = findViewById(R.id.et_username);
        mEtPassword = findViewById(R.id.et_password);
        mTextViewNoAcount = findViewById(R.id.tv_no_acount);

        mTextViewNoAcount.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);  //中划线

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setUsername(mEtUsername.getText().toString().trim());
                user.setPassword(mEtPassword.getText().toString().trim());
                user.login(new SaveListener<User>() {

                    @Override
                    public void done(User user, BmobException e) {
                        if(e == null)
                        {
                            startActivity(new Intent(MainActivityEditText.this,MainActivity.class));
                            finish();
                        }else
                        {
                            ToastUtil.showMsg(MainActivityEditText.this,"登录失败："+e.getMessage());
                        }
                    }
                });
            }
        });
        mTextViewNoAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityEditText.this,MainActivitySignUp.class));
                finish();
            }
        });
    }
}
