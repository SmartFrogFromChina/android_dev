package com.frog.ui.ActivityJump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.frog.ui.R;
import com.frog.ui.Util.ToastUtil;

public class MainActivityJumpFirst extends AppCompatActivity {

    private Button mBtnFirst;
    private EditText mEditTextName,mEditTextAge,mEditTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jump_first);

        mBtnFirst = findViewById(R.id.btn_jump_to_first);
        mEditTextName = findViewById(R.id.et_jump_first_username);
        mEditTextAge = findViewById(R.id.et_jump_first_age);
        mEditTextDate = findViewById(R.id.et_jump_first_date);

        mBtnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                //方式1
//                intent = new Intent(MainActivityJumpFirst.this,MainActivityJumpSecond.class);
//
//                //方式2
//                intent = new Intent();
//                intent.setClass(MainActivityJumpFirst.this,MainActivityJumpSecond.class);
//
//                //方式3
//                intent = new Intent();
//                intent.setClassName(MainActivityJumpFirst.this,"com.frog.ui.ActivityJump.MainActivityJumpSecond");
//
//                //方式4
//                intent = new Intent();
//                intent.setComponent(new ComponentName(MainActivityJumpFirst.this,"com.frog.ui.ActivityJump.MainActivityJumpSecond"));
//
//                //方式5
//                intent = new Intent();
//                intent.setAction("com.frog.ui_second");
//                startActivity(intent);
                intent = new Intent(MainActivityJumpFirst.this,MainActivityJumpSecond.class);
                intent.putExtra("name",mEditTextName.getText().toString());
                intent.putExtra("age", Integer.parseInt(mEditTextAge.getText().toString()));
                intent.putExtra("date",mEditTextDate.getText().toString());

                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String username = data.getExtras().getString("username","init");
        String password = data.getExtras().getString("password","init");
        String nickname = data.getExtras().getString("nickname","init");

        ToastUtil.showMsg(getApplicationContext(),"username:"+username+"  password:"+password+"  nickanme:"+nickname);
    }
}