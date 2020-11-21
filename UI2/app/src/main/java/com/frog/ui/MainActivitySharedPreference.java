package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivitySharedPreference extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditText;
    private Button mButtonSave,mButtonRead;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shared_preference);

        mTextView = findViewById(R.id.tv_show);
        mEditText = findViewById(R.id.et_input);
        mButtonSave = findViewById(R.id.btn_preference_save);
        mButtonRead = findViewById(R.id.btn_preference_read);

        mSharedPreferences = getSharedPreferences("info",MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();


        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name",mEditText.getText().toString().trim());
                mEditor.apply();
            }
        });
        mButtonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mSharedPreferences.getString("name","read error"));
            }
        });

    }
}