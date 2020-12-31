package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivityTextView extends AppCompatActivity {

    private TextView text_view,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_text_view);

        text_view = findViewById(R.id.tv2);
        text_view.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);  //中划线
        text_view.getPaint().setAntiAlias(true);  //去掉锯齿


        tv3 = findViewById(R.id.tv3);
        tv3.setText(Html.fromHtml("<u>你好啊</u>"));

        tv4 = findViewById(R.id.tv4);
        tv4.setSelected(true);
    }


}
