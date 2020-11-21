package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.frog.ui.Util.ToastUtil;

public class MainActivityProperty extends AppCompatActivity {

    private Button mBtn1,mBtn2,mBtn3;
    int show_flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_property);
        mBtn1 = findViewById(R.id.btn_property);
        mBtn2 = findViewById(R.id.btn_property2);
        mBtn3 = findViewById(R.id.btn_property3);

        mBtn1.animate().translationYBy(500).setDuration(3000).start();
        mBtn2.animate().alpha(0).setDuration(3000).start();

        ValueAnimator valueAnimator =ValueAnimator.ofInt(0,100);
        valueAnimator.setDuration(2000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                Log.d("test",animation.getAnimatedValue()+"");
                if(Integer.parseInt(animation.getAnimatedValue()+"") == 50)
                {
                    ToastUtil.showMsg(getApplicationContext(),"加载一半了");
                }
                if(show_flag ==0 && animation.getAnimatedFraction() > 0.8)
                {
                    show_flag = 1;
                    ToastUtil.showMsg(getApplicationContext(),"加载八成了");
                }
            }
        });

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBtn3,"translationY",0,1000,800,1000,900,1000,950,1000);
        objectAnimator.setDuration(3000);
        objectAnimator.start();

    }
}