package com.frog.ui.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.frog.ui.R;

public class MainActivityContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);

        WaterFragment waterFragment = WaterFragment.instance("我是传递的参数");
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,waterFragment).commitAllowingStateLoss();

    }
}