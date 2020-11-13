package com.frog.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivityProgress extends AppCompatActivity {

    private Button mBtnProgress1,mBtnProgressDialog1,mBtnProgressDialog2;
    private ProgressBar mProgressBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_progress);

        mBtnProgress1 = findViewById(R.id.btn_progress_bar);
        mProgressBar1 = findViewById(R.id.pb_1);
        mBtnProgressDialog1 = findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progress_dialog2);

        mBtnProgress1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mProgressBar1.setProgress(0);
                handler.sendEmptyMessage(0);
            }
        });
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog1 = new ProgressDialog(MainActivityProgress.this);
                progressDialog1.setTitle("提示");
                progressDialog1.setMessage("下载中。。。");
                progressDialog1.show();
            }
        });
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog2 = new ProgressDialog(MainActivityProgress.this);
                progressDialog2.setTitle("警告");
                progressDialog2.setMessage("处理中。。。");
                progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog2.show();
                progressDialog2.setButton(DialogInterface.BUTTON_POSITIVE, "好啊", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });


    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(mProgressBar1.getProgress() < 100 )
                handler.postDelayed(runnable,500);
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mProgressBar1.setProgress(mProgressBar1.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };
}