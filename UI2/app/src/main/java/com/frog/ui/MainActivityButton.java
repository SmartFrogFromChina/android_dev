package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityButton extends AppCompatActivity {

    private Button btn_12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_button);

        btn_12 = findViewById(R.id.btn12);
        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivityButton.this,"你好啊",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
