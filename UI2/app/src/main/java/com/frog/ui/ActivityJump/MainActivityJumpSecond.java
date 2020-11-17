package com.frog.ui.ActivityJump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.frog.ui.R;

public class MainActivityJumpSecond extends AppCompatActivity {

    private TextView mTextView;
    private Button mBtnSecond;
    private EditText mEditTextUsername,mEditTextPassword,mEditTextNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jump_second);

        mTextView = findViewById(R.id.tv_jump_second);
        mBtnSecond = findViewById(R.id.btn_jump_to_second);
        mEditTextUsername = findViewById(R.id.et_second_username);
        mEditTextPassword = findViewById(R.id.et_second_password);
        mEditTextNickname = findViewById(R.id.et_second_nickname);


        String name = getIntent().getExtras().getString("name","read error");
        int age = getIntent().getExtras().getInt("age",18);
        String date = getIntent().getExtras().getString("date","19700101");
        mTextView.setText("name:"+name+"  age:"+age+"  date:"+date);

        mBtnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.putExtra("username",mEditTextUsername.getText().toString());
                intent.putExtra("password",mEditTextPassword.getText().toString());
                intent.putExtra("nickname",mEditTextNickname.getText().toString());
                setResult(0,intent);
                //startActivity(intent);
                finish();
            }
        });
    }
}