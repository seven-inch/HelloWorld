package com.helloworld.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.helloworld.R;
import com.helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    private Button mBtnJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "taskid" + " : " + getTaskId() + ", hash : " + hashCode());
        logtaskName();
        mBtnJump = (Button) findViewById(R.id.jump);
        mBtnJump2 = (Button) findViewById(R.id.jump_2);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                //Activity之间的数据传递是通过Bundle实现的
                Bundle bundle = new Bundle();
                bundle.putString("name", "MU");
                bundle.putInt("number", 20);
                intent.putExtras(bundle);
                startActivity(intent);
                //startActivityForResult(intent, 0);
                //显式跳转2
                //Intent intent = new Intent();
                //intent.setClass(AActivity.this, BActivity.class);
                //startActivity(intent);
                //显式跳转3
                //Intent intent = new Intent();
                //intent.setClassName(AActivity.this, "com.helloworld.jump.BActivity");
                //startActivity(intent);
                //显式跳转4
                //Intent intent = new Intent();
                //intent.setComponent(new ComponentName(AActivity.this,"com.helloworld.jump.BActivity"));
                //startActivity(intent);

                //隐式跳转
                //Intent intent = new Intent();
                //intent.setAction("com.helloworld.test.BActivity");//在Mainnifest里设置
                //startActivity(intent);

            }
        });
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtil.showMsg(AActivity.this, data.getExtras().getString("title"));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity", "----onNewIntent----");
        Log.d("AActivity", "taskid" + " : " + getTaskId() + ", hash : " + hashCode());
        logtaskName();
    }

    private void logtaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity", info.taskAffinity);
            ;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}