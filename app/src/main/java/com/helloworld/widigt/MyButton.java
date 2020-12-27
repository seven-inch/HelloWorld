package com.helloworld.widigt;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {


    public MyButton(@NonNull Context context) {
        super(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*//基于回调事件的处理机制
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton", "---onTouchEvent---");
                break;
        }
        return true;
    }*/

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("MyButton", "---dispatchTouchEvent---");
        return super.dispatchTouchEvent(event);
    }

    //源发剖析，了解View的事件分发
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton", "---onTouchEvent---");
                break;
        }
        return super.onTouchEvent(event);
    }
}
