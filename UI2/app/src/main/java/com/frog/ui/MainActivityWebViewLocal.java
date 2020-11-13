package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivityWebViewLocal extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_view_local);

        mWebView = findViewById(R.id.wv_local);

        mWebView.loadUrl("file:///android_asset/index.html");
    }
}