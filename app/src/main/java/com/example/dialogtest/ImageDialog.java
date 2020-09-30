package com.example.dialogtest;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

public class ImageDialog extends Dialog {
    /**
     * 显示的图片
     */
    private ImageView ivShow;
    /**
     * 取消按钮
     */
    private ImageView ivCancel;

    private String url;

    private Context context;

    public ImageDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);
        this.context = context;
        setContentView(R.layout.dialog_image);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);
        //初始化界面控件
        initView();
    }

    public void initView(){
        ivShow = findViewById(R.id.iv_show);
        ivCancel = findViewById(R.id.iv_cancel);
        ivShow.setImageResource(R.drawable.jifen);
        ivCancel.setImageResource(R.drawable.cancel);
    }

    public interface OnClickBottomListener{
        /**
         * 点击确定按钮事件
         */
        public void onPositiveClick();
        /**
         * 点击取消按钮事件
         */
        public void onNegtiveClick();
    }


    /**
     * 设置确定取消按钮的回调
     */
    public ImageDialog setOnClickBottomListener(final OnClickBottomListener onClickBottomListener) {
        //设置确定按钮被点击后，向外界提供监听
        ivShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( onClickBottomListener!= null) {
                    onClickBottomListener.onPositiveClick();
                    dismiss();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( onClickBottomListener!= null) {
                    onClickBottomListener.onNegtiveClick();
                    dismiss();
                }
            }
        });
        return this;
    }

    public ImageDialog setUrl(String url){
        if (!TextUtils.isEmpty(url)){
            Glide.with(context).load(url).into(ivShow);
        }
        return this;
    }

}
