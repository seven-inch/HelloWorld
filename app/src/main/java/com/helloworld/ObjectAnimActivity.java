package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView mTvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        mTvTest = (TextView) findViewById(R.id.tv);

        //mTvTest.animate().translationYBy(1000).setDuration(3000).start();
        //mTvTest.animate().alpha(0).setDuration(2000).start();
        /*ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //valueAnimator 实际的值
                Log.d("aaaa", animation.getAnimatedValue()+"");
                //动画的进度0-1
                Log.d("aaaa", animation.getAnimatedFraction()+"");
            }
        });
        valueAnimator.start();*/

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvTest, "translationY", 0,1000,200,500);
        objectAnimator.setDuration(4000);
        objectAnimator.start();
    }
}