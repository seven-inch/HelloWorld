package com.helloworld.widigt;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.helloworld.R;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;
    private IOnCancelLinstener cancelLinstener;
    private IOnConfirmLinstener confirmLinstener;

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelLinstener linstener) {
        this.cancel = cancel;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmLinstener linstener) {
        this.confirm = confirm;
        return this;
    }

    private String title, message, cancel, confirm;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context,int themId) {
        super(context, themId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //设置宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8);  //设置dialog宽度为当前手机屏幕宽度的80%
        getWindow().setAttributes(p);

        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvMessage = (TextView) findViewById(R.id.tv_message);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvConfirm = (TextView) findViewById(R.id.tv_confirm);
        //判断title不为null不为" "
        if(!TextUtils.isEmpty(title)){
            mTvTitle.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            mTvMessage.setText(message);
        }
        if(!TextUtils.isEmpty(cancel)){
            mTvCancel.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){
            mTvConfirm.setText(confirm);
        }

        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                if(cancelLinstener != null){
                    cancelLinstener.onCancel(this);
                }
                //dismiss();
                break;
            case R.id.tv_confirm:
                if(confirmLinstener != null){
                    confirmLinstener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelLinstener{
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmLinstener{
        void onConfirm(CustomDialog dialog);
    }
}
