package com.helloworld.Event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.helloworld.R;
import com.helloworld.util.ToastUtil;
import com.helloworld.widigt.MyButton;

// 一、二、
/*public class EventActivity extends AppCompatActivity{*/
//三、
public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent;
    private MyButton mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = (Button) findViewById(R.id.btn_event);
        mBtnMy = (MyButton) findViewById(R.id.btn_my);
        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "---onTouch---");
                        break;
                }
                return false;
            }
        });
        //一、通过内部类实现
        mBtnEvent.setOnClickListener(new OnClick());

        //二、通过匿名内部类实现
        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("匿名内部类", "click...");
                ToastUtil.showMsg(EventActivity.this, "click...（匿名内部类）");
            }
        });

        /*//三、通过事件源所在类实现
        mBtnEvent.setOnClickListener(EventActivity.this);*/

        /*//四、通过外部类实现
        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));*/

        //五、通过布局文件中的OnClick属性（针对点击事件）


    }


    //一、通过内部类实现
    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event:
                    Log.d("内部类", "click...");
                    ToastUtil.showMsg(EventActivity.this, "click...（内部类）");
                    break;
            }
        }
    }

    //三、通过事件源所在类实现（让Activity实现接口View.OnClickListener
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "click...（事件源所在类内部类）");
                break;
        }
    }

    //五、通过布局文件中的OnClick属性（针对点击事件）,一定是在布局文件中定义的名称以及public 的，无返回类型的函数
    public void show(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                Log.d("布局文件的OnClick属性", "click...");
                ToastUtil.showMsg(EventActivity.this, "click...（布局文件中的OnClick属性（针对点击事件））");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","---onTouchEvent---");
                break;
        }
        return false;
    }
}