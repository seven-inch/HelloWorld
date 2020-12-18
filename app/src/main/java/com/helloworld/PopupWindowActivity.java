package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.helloworld.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnPop;
    private PopupWindow mPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPop = (Button) findViewById(R.id.btn_pop);
        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_popup_window, null);
                TextView mTvGood = view.findViewById(R.id.tv_good);
                mTvGood.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPop.dismiss();
                        //do something...
                        ToastUtil.showMsg(PopupWindowActivity.this, "好");
                    }
                });
                mPop = new PopupWindow(view,mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true);
                mPop.setFocusable(true);
                mPop.setBackgroundDrawable(new BitmapDrawable());
                mPop.showAsDropDown(mBtnPop);

            }
        });

    }
}