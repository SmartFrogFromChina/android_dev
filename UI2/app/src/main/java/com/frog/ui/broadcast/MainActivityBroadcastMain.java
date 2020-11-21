package com.frog.ui.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.frog.ui.R;

public class MainActivityBroadcastMain extends AppCompatActivity {

    private Button mBtnJump;
    private TextView mTextView;
    MyBroadcast myBroadcast = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broadcast_main);

        mBtnJump = findViewById(R.id.btn_broadcast_main);
        mTextView = findViewById(R.id.tv_broadcast);

        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivityBroadcastBranch.class);
                startActivity(intent);
            }
        });

        myBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.frog.ui.send");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(myBroadcast,intentFilter);

    }

    public class MyBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            switch(intent.getAction())
            {
                case "com.frog.ui.send":
                    mTextView.setText("Received broadcast");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(myBroadcast);
    }
}