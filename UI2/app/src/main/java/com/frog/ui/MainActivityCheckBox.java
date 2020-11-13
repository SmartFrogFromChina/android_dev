package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivityCheckBox extends AppCompatActivity {

    private CheckBox mCheckBox1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_check_box);

        mCheckBox1 = findViewById(R.id.cb_1);
        mCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivityCheckBox.this,isChecked?"被选中":"已取消",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
