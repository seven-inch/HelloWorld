package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.helloworld.util.ToastUtil;
import com.helloworld.widigt.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnDialog = findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this, R.style.Custom_Dialog);
                customDialog.setTitle("提示").setMessage("确认删除此项？")
                        .setCancel("取消", new CustomDialog.IOnCancelLinstener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {
                                ToastUtil.showMsg(CustomDialogActivity.this, "cancel...");
                            }
                        }).setConfirm("确认", new CustomDialog.IOnConfirmLinstener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this, "confirm...");
                    }
                }).show();
            }
        });

    }
}