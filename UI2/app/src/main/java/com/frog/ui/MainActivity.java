package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUserInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        mBtnUserInterface = findViewById(R.id.btn_user_interface);
        mBtnUserInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivityUserInterface.class);
                startActivity(intent);
            }
        });
    }
}