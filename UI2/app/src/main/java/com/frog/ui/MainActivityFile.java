package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.frog.ui.Util.ToastUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivityFile extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditText;
    private Button mButtonInternalSave,mButtonInternalRead;
    private Button mButtonExternalSave,mButtonExternalRead;
    private Button mButtonCommonSave,mButtonCommonRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_file);

        mTextView = findViewById(R.id.tv_file_show);
        mEditText = findViewById(R.id.et_file_input);
        mButtonInternalSave = findViewById(R.id.btn_file_save);
        mButtonInternalRead = findViewById(R.id.btn_file_read);
        mButtonExternalSave = findViewById(R.id.btn_external_file_save);
        mButtonExternalRead = findViewById(R.id.btn_external_file_read);
        mButtonCommonSave = findViewById(R.id.btn_downloads_save);
        mButtonCommonRead = findViewById(R.id.btn_downloads_read);

        mButtonInternalSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                internal_save(mEditText.getText().toString());
            }
        });
        mButtonInternalRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(internal_read());
            }
        });
        mButtonExternalSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                external_save(mEditText.getText().toString());
            }
        });
        mButtonExternalRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(external_read());
            }
        });
        mButtonCommonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                external_common_save(mEditText.getText().toString());
            }
        });
        mButtonCommonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(external_common_read());
            }
        });
    }

    private void external_common_save(String content)
    {
        FileOutputStream fileOutputStream = null;
        try {
            File dir = new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/test"));
            if(!dir.exists()){
                dir.mkdir();
            }
            else{
                ToastUtil.showMsg(getApplicationContext(),"目录已存在"+dir.getAbsolutePath());
            }
            File file = new File(dir,"1.txt");
            if(!file.exists()){
                if( file.createNewFile() == true){
                    ToastUtil.showMsg(getApplicationContext(),"创建文件成功");
                }
                else{
                    ToastUtil.showMsg(getApplicationContext(),"创建文件失败");
                    return ;
                }
            }
            //fileOutputStream = openFileOutput("1.txt",MODE_APPEND);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String external_common_read()
    {
        FileInputStream fileInputStream = null;
        byte []buff = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        int len = 0;
        try {
            //fileInputStream = openFileInput("1.txt");
            File dir = new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/test"));
            File file = new File(dir,"1.txt");
            if(!file.exists())
            {
                ToastUtil.showMsg(getApplicationContext(),"File not exist");
                return null;
            }
            fileInputStream  = new FileInputStream(file);

            while((len = fileInputStream.read(buff)) > 0)
            {
                stringBuilder.append(new String(buff,0,len));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void external_save(String content)
    {
        FileOutputStream fileOutputStream = null;
        try {
            File dir = new File(String.valueOf(getExternalFilesDir(null)+"/test"));
            if(!dir.exists()){
                dir.mkdir();
            }
            else{
                ToastUtil.showMsg(getApplicationContext(),"目录已存在"+dir.getAbsolutePath());
            }
            File file = new File(dir,"1.txt");
            if(!file.exists()){
               if( file.createNewFile() == true){
                   ToastUtil.showMsg(getApplicationContext(),"创建文件成功");
               }
               else{
                   ToastUtil.showMsg(getApplicationContext(),"创建文件失败");
                   return ;
               }
            }
            //fileOutputStream = openFileOutput("1.txt",MODE_APPEND);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String external_read()
    {
        FileInputStream fileInputStream = null;
        byte []buff = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        int len = 0;
        try {
            //fileInputStream = openFileInput("1.txt");
            File dir = new File(String.valueOf(getExternalFilesDir(null)+"/test"));
            File file = new File(dir,"1.txt");
            if(!file.exists())
            {
                ToastUtil.showMsg(getApplicationContext(),"File not exist");
                return null;
            }
            fileInputStream  = new FileInputStream(file);

            while((len = fileInputStream.read(buff)) > 0)
            {
                stringBuilder.append(new String(buff,0,len));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    private void internal_save(String content)
    {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("1.txt",MODE_APPEND);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String internal_read()
    {
        FileInputStream fileInputStream = null;
        byte []buff = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        int len = 0;
        try {
            fileInputStream = openFileInput("1.txt");
            while((len = fileInputStream.read(buff)) > 0)
            {
                stringBuilder.append(new String(buff,0,len));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}