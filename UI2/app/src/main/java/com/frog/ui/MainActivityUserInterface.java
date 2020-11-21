package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.frog.ui.ActivityJump.MainActivityJumpFirst;
import com.frog.ui.broadcast.MainActivityBroadcastMain;
import com.frog.ui.fragment.MainActivityContainer;

public class MainActivityUserInterface extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    private Button btn9,btn10,btn11,btn12,btn13,btn14,btn15;
    private Button btn16,btn17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_interface);

        /*
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn1Intent = new Intent(MainActivity.this,ButtonActivity.class);
                startActivity(btn1Intent);
            }
        });

        btn2 = findViewById(R.id.edit_text);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn1Intent = new Intent(MainActivity.this,EditTextActivity.class);
                startActivity(btn1Intent);
            }
        });
        */
        btn1 = findViewById(R.id.button_sample);
        btn2 = findViewById(R.id.edit_text);
        btn3 = findViewById(R.id.radio_button);
        btn4 = findViewById(R.id.checkbox_button);
        btn5 = findViewById(R.id.btn_image_view);
        btn6 = findViewById(R.id.btn_scroll_view);
        btn7 = findViewById(R.id.btn_web_view);
        btn8 = findViewById(R.id.btn_toast);
        btn9 = findViewById(R.id.btn_alert_dialog);
        btn10 =findViewById(R.id.btn_progress);
        btn11 = findViewById(R.id.btn_life_cycle);
        btn12 = findViewById(R.id.btn_jump);
        btn13 = findViewById(R.id.btn_fragment);
        btn14 = findViewById(R.id.btn_shared_preference);
        btn15 = findViewById(R.id.btn_file);
        btn16 = findViewById(R.id.btn_local_broadcast);
        btn17 = findViewById(R.id.btn_main_property);
        setListers();
    }

    private void setListers()
    {
        OnClick onClick = new OnClick();
        btn1.setOnClickListener(onClick);
        btn2.setOnClickListener(onClick);
        btn3.setOnClickListener(onClick);
        btn4.setOnClickListener(onClick);
        btn5.setOnClickListener(onClick);
        btn6.setOnClickListener(onClick);
        btn7.setOnClickListener(onClick);
        btn8.setOnClickListener(onClick);
        btn9.setOnClickListener(onClick);
        btn10.setOnClickListener(onClick);
        btn11.setOnClickListener(onClick);
        btn12.setOnClickListener(onClick);
        btn13.setOnClickListener(onClick);
        btn14.setOnClickListener(onClick);
        btn15.setOnClickListener(onClick);
        btn16.setOnClickListener(onClick);
        btn17.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch(v.getId())
            {
                case R.id.button_sample:
                    intent = new Intent(MainActivityUserInterface.this, MainActivityButton.class);
                    break;
                case R.id.edit_text:
                    intent = new Intent(MainActivityUserInterface.this, MainActivityEditText.class);
                    break;

                case R.id.radio_button:
                    intent = new Intent(MainActivityUserInterface.this, MainActivityRadioButton.class);
                    break;
                case R.id.checkbox_button:
                    intent = new Intent(MainActivityUserInterface.this, MainActivityCheckBox.class);
                    break;
                case R.id.btn_image_view:
                    intent = new Intent(MainActivityUserInterface.this,MainActivityImageView.class);
                    break;
                case R.id.btn_scroll_view:
                    intent = new Intent(MainActivityUserInterface.this,MainActivityScrollView.class);
                    break;
                case R.id.btn_web_view:
                    intent = new Intent(MainActivityUserInterface.this,MainActivityWebView.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(MainActivityUserInterface.this,MainActivityToast.class);
                    break;
                case R.id.btn_alert_dialog:
                    intent = new Intent(getApplicationContext(),MainActivityAlertDialog.class);
                    break;
                case R.id.btn_progress:
                    intent = new Intent(getApplicationContext(),MainActivityProgress.class);
                    break;
                case R.id.btn_life_cycle:
                    intent = new Intent(getApplicationContext(),MainActivityLifeCycle.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(getApplicationContext(), MainActivityJumpFirst.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(getApplicationContext(), MainActivityContainer.class);
                    break;
                case R.id.btn_shared_preference:
                    intent = new Intent(getApplicationContext(), MainActivitySharedPreference.class);
                    break;
                case R.id.btn_file:
                    intent = new Intent(getApplicationContext(), MainActivityFile.class);
                    break;
                case R.id.btn_local_broadcast:
                    intent = new Intent(getApplicationContext(), MainActivityBroadcastMain.class);
                    break;
                case R.id.btn_main_property:
                    intent = new Intent(getApplicationContext(), MainActivityProperty.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
