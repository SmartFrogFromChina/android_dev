package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.frog.ui.Util.ToastUtil;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivitySignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);

        EditText mEditTextNickName,mEditTextUserName,mEditTextPassword;
        Button mBtnSignUp;

        mEditTextNickName = findViewById(R.id.et_sign_up_nickname);
        mEditTextUserName = findViewById(R.id.et_sign_up_username);
        mEditTextPassword = findViewById(R.id.et_sign_up_password);
        mBtnSignUp = findViewById(R.id.btn_sign_up);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();

                user.setNickname(mEditTextNickName.getText().toString().trim());
                user.setUsername(mEditTextUserName.getText().toString().trim());
                user.setPassword(mEditTextPassword.getText().toString().trim());

                user.signUp(new SaveListener<User>() {
                    @Override
                    public void done(User user, BmobException e) {
                        if(e == null)
                        {
                            ToastUtil.showMsg(MainActivitySignUp.this,"注册成功");
                            startActivity(new Intent(MainActivitySignUp.this,MainActivity.class));
                            finish();
                        }else{
                            ToastUtil.showMsg(MainActivitySignUp.this,"注册失败"+e.getMessage());
                        }
                    }
                });
            }
        });

    }
}