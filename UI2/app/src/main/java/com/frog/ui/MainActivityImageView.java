package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivityImageView extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_image_view);
        mImageView = findViewById(R.id.iv6);
        Glide.with(this).load("https://www.baidu.com/img/flexible/logo/pc/result.png").into(mImageView);
    }
}