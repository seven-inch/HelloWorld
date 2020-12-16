package com.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.helloworld.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb3;
    private Button mBtnStart, mBtnProgressDialog1, mBtnProgressDialog2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPb3 = (ProgressBar) findViewById(R.id.pb3);
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnProgressDialog1 = (Button) findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2 = (Button) findViewById(R.id.btn_progress_dialog2);
        OnClick onClick = new OnClick();
        mBtnStart.setOnClickListener(onClick);
        mBtnProgressDialog1.setOnClickListener(onClick);
        mBtnProgressDialog2.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_start:
                    handler.sendEmptyMessage(0);
                    break;
                case R.id.btn_progress_dialog1:
                    ProgressDialog progressDialog1 = new ProgressDialog(ProgressActivity.this);
                    progressDialog1.setTitle("提示");
                    progressDialog1.setMessage("正在加载");
                    progressDialog1.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            ToastUtil.showMsg(ProgressActivity.this, "cancel...");
                        }
                    });
                    // 这个Dialog是否可以阻断
                    // progressDialog.setCancelable(false);
                    progressDialog1.show();
                    break;
                case R.id.btn_progress_dialog2:
                    ProgressDialog progressDialog2 = new ProgressDialog(ProgressActivity.this);
                    progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog2.setTitle("提示");
                    progressDialog2.setMessage("正在下载...");
                    progressDialog2.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(ProgressActivity.this, "成功...");
                        }
                    });
                    progressDialog2.show();
                    break;
            }
        }
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mPb3.getProgress() < 100) {
                handler.postDelayed(runnable, 500);
            } else {
                ToastUtil.showMsg(ProgressActivity.this, "加载完成");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}