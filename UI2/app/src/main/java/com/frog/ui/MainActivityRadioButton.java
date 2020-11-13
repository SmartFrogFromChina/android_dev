package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivityRadioButton extends AppCompatActivity {

    private RadioGroup mRadioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_radio_button);
        mRadioGroup2 = findViewById(R.id.rg_2);
        mRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(MainActivityRadioButton.this,radioButton.getText()+"被选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
