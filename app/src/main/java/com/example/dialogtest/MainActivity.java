package com.example.dialogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initDialog();
        showImageDialog();
    }

    private void showImageDialog(){
        final ImageDialog dialog = new ImageDialog(MainActivity.this);
        dialog.setUrl("").setOnClickBottomListener(new ImageDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                //点击图片的事件
                Toast.makeText(MainActivity.this,"跳转",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNegtiveClick() {
                //点击取消按钮的事件
                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();

            }
        }).show();
    }


    private void initDialog() {
        final CommonDialog dialog = new CommonDialog(MainActivity.this);
        dialog.setMessage("这是一个自定义Dialog。")
                .setImageResId(R.mipmap.ic_launcher)
                .setTitle("系统提示")
                .setSingle(false).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"xxxx",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"ssss",Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}