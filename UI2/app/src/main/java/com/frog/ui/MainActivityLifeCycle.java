package com.frog.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLifeCycle extends AppCompatActivity {
    private TextView mTextView;
    private String msg = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_life_cycle);

        mTextView = findViewById(R.id.tv_life_cycle);
        if(msg == null)
            msg ="---onCreate-----\n";
        else
            msg +="---onCreate-----\n";
        Log.d("lifecycle","---onCreate-----");
        mTextView.setText(msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","---onStart-----");
        msg +="---onStart-----\n";
        mTextView.setText(msg);
    }

    @Override
    protected void onResume() {
        super.onResume();
        msg +="---onResume-----\n";
        Log.d("lifecycle","---onResume-----");
        mTextView.setText(msg);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        msg +="---onRestart-----\n";
        Log.d("lifecycle","---onRestart-----");
        mTextView.setText(msg);
    }

    @Override
    protected void onPause() {
        super.onPause();
        msg +="---onPause-----\n";
        Log.d("lifecycle","---onPause-----");
        mTextView.setText(msg);
    }

    @Override
    protected void onStop() {
        super.onStop();
        msg +="---onStop-----\n";
        Log.d("lifecycle","---onStop-----");
        mTextView.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        msg +="---onDestroy-----\n";
        Log.d("lifecycle","---onDestroy-----");
        mTextView.setText(msg);
    }
}

