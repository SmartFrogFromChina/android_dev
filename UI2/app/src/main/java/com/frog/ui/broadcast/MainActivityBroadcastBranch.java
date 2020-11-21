package com.frog.ui.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.frog.ui.R;

public class MainActivityBroadcastBranch extends AppCompatActivity {

    private Button mBtnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broadcast_branch);

        mBtnSend = findViewById(R.id.btn_broadcast_send);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inent = new Intent("com.frog.ui.send");
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(inent);
            }
        });
    }
}