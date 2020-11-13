package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivityWebView extends AppCompatActivity {

    private Button mBtnWebviewLocal,mBtnWebviewUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_view);

        mBtnWebviewLocal = findViewById(R.id.btn_web_local);
        mBtnWebviewLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityWebView.this,MainActivityWebViewLocal.class);
                startActivity(intent);
            }
        });

        mBtnWebviewUrl = findViewById(R.id.btn_web_remote);
        mBtnWebviewUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityWebView.this,MainActivityWebviewUrl.class);
                startActivity(intent);
            }
        });

    }
}