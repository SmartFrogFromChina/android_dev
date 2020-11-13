package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.frog.ui.Util.ToastUtil;

public class MainActivityToast extends AppCompatActivity {

    private Button mButtonToast1,mButtonToast2,mButtonToast3,mButtonToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_toast);

        mButtonToast1 = findViewById(R.id.btn_toast1);
        mButtonToast2 = findViewById(R.id.btn_toast2);
        mButtonToast3 = findViewById(R.id.btn_toast3);
        mButtonToast4 = findViewById(R.id.btn_toast4);

        OnClick onClick = new OnClick();
        mButtonToast1.setOnClickListener(onClick);
        mButtonToast2.setOnClickListener(onClick);
        mButtonToast3.setOnClickListener(onClick);
        mButtonToast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch(v.getId())
            {
                case R.id.btn_toast1:
                    Toast.makeText(getApplicationContext(),"默认位置",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(),"中间位置",Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
                    View view = layoutInflater.inflate(R.layout.toast_wifi,null);
                    ImageView imageView = view.findViewById(R.id.toast_image_view);
                    TextView textView = view.findViewById(R.id.toast_text_view);
                    imageView.setImageResource(R.drawable.wifi);
                    textView.setText("WIFI已断开");
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast4:
                    ToastUtil.showMsg(getApplicationContext(),"这是封装过的Toast");
                    break;
            }
        }
    }
}