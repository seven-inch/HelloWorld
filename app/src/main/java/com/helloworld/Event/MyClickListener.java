package com.helloworld.Event;

import android.app.Activity;
import android.view.View;

import com.helloworld.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity activity;
    public MyClickListener(Activity activity){
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(activity, "click...（外部类实现）");
    }
}
