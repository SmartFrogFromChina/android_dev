package com.frog.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.frog.ui.Util.ToastUtil;

public class MainActivityAlertDialog extends AppCompatActivity {

    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4,mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alert_dialog);


        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        mBtnDialog5 = findViewById(R.id.btn_dialog5);

        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivityAlertDialog.this);
                    builder1.setTitle("饭菜如何")
                            .setIcon(R.drawable.wifi)
                            .setPositiveButton("好吃", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(getApplicationContext(),"感谢评价");
                                }
                            })
                            .setNeutralButton("一般般", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(getApplicationContext(),"请留下意见");
                                }
                            })
                            .setNegativeButton("很差", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(getApplicationContext(),"很抱歉");
                                }
                            }).show();
                    break;
                case R.id.btn_dialog2:
                    final String [] array2 = new String[]{"金","木","水","火","土"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivityAlertDialog.this);
                    builder2.setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(getApplicationContext(),array2[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String [] array3 = new String[]{"金","木","水","火","土"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivityAlertDialog.this);
                    builder3.setTitle("选择五行")
                            .setSingleChoiceItems(array3, 1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(getApplicationContext(),array3[which]);
                                    dialog.dismiss(); //点完就消失
                                }
                            })
                            .setCancelable(false)  //点击弹框外面，弹框不会消失
                            .show();
                    break;
                case R.id.btn_dialog4:
                    final String [] array4 = new String[]{"C","Java","H5","PHP"};
                    Boolean [] bool4 = new Boolean[]{false,false,true,false};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(MainActivityAlertDialog.this);
                    builder4.setTitle("你会哪些语言")
//                            .setMultiChoiceItems(array4, bool4, new DialogInterface.OnMultiChoiceClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//
//                                }
//                            })
                            .show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(MainActivityAlertDialog.this);
                    View view = LayoutInflater.from(MainActivityAlertDialog.this).inflate(R.layout.activity_main_edit_text,null);

                    builder5.setView(view).show();
                    break;

            }
        }
    }
}