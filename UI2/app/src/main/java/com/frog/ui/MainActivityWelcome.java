package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class MainActivityWelcome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_welcome);

        Timer timer = new Timer();
        timer.schedule(timertask,3000);

        //第一：默认初始化
       // Bmob.initialize(this, "13b51c4d8260c30d68666900a7b55c50");

    }

    TimerTask timertask = new TimerTask() {
        @Override
        public void run() {
               startActivity(new Intent(MainActivityWelcome.this, MainActivity.class));
        }
    };
}