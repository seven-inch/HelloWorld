package com.helloworld.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.helloworld.R;

public class BroadActivity extends AppCompatActivity {

    private Button mBtnJump;
    private TextView mTvTest;
    private MyBroadcast myBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);
        mBtnJump = (Button) findViewById(R.id.btn_jump);
        mTvTest = (TextView) findViewById(R.id.tv_text);

        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadActivity.this,BroadActivity2.class);
                startActivity(intent);
            }
        });

        myBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.helloworld.update");
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcast, intentFilter);
    }

    private class MyBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.helloworld.update":
                    mTvTest.setText("123");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //将广播注销
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcast);
    }
}