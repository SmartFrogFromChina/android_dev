package com.frog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MainActivityAesCryDec extends AppCompatActivity {

    private Button mBtnCry,mBtnDec;
    private EditText mEtData;
    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aes_cry_dec);

        mBtnCry = findViewById(R.id.btn_aes_cry);
        mBtnDec = findViewById(R.id.btn_aes_dec);
        mEtData = findViewById(R.id.et_aes_data);
        mTvShow = findViewById(R.id.tv_aes_show);

        mBtnCry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String str = encrypte(mEtData.getText().toString().trim());
                    mTvShow.setText(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mBtnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String str = decrypte(mEtData.getText().toString().trim());
                    mTvShow.setText(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    private static String getKEY() {
        return "JoEoxwbdVQ4bKjWEndfn9ntgeWg";
    }

    public static Key createKey() {
        String str = "AES";
        try {
            KeyGenerator instance = KeyGenerator.getInstance(str);
            instance.init(128);
            return new SecretKeySpec(instance.generateKey().getEncoded(), str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] jdkAES(String str, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, key);
            return instance.doFinal(str.getBytes());
    }

    public static String encrypte(String str) throws Exception {
            return AESCBCUtils.encrypt(str, HTTP.UTF_8, getVal1(), getVal2());
    }

    public static String decrypte(String str) throws NoSuchPaddingException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
            return AESCBCUtils.decrypt(str, HTTP.UTF_8, getVal1(), getVal2());
    }

    public static StringBuffer getStr() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = "ac292df2b564f741AA1346a48d4081dcbeAAJoEoxwbdVQ4bKjWEnAAF7RdtXjHTPX1iD97G4bAAPlyVjhmvxkXsThzRE";
        stringBuffer.append(str);
        String key = getKEY();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        str = "|";
        stringBuilder.append(str);
        stringBuilder.append(key);
        String stringBuilder2 = stringBuilder.toString();
        stringBuffer.append(stringBuilder2);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(str);
        stringBuilder3.append(key);
        stringBuilder2 = stringBuilder3.toString();
        stringBuffer.append(stringBuilder2);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(str);
        stringBuilder3.append(key);
        stringBuilder2 = stringBuilder3.toString();
        stringBuffer.append(stringBuilder2);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(str);
        stringBuilder3.append(key);
        stringBuffer.append(stringBuilder3.toString());
        return stringBuffer;
    }

    public static String getVal1() {
        return getStr().toString().split("AA")[0];
    }

    public static String getVal2() {
        return getStr().toString().split("AA")[1];
    }

    static class AESCBCUtils {
        public static String encrypt(String str, String str2, String str3, String str4) throws Exception {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(str3.getBytes(), "AES"), new IvParameterSpec(str4.getBytes()));
            return Base64.encodeToString(instance.doFinal(str.getBytes(str2)), 2);
        }

        public static String decrypt(String str, String str2, String str3, String str4) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(str3.getBytes(), "AES"), new IvParameterSpec(str4.getBytes()));
            byte[] encrypted1 = Base64.decode(str, 2);
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original);
        }
    }
}