package com.helloworld.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.helloworld.R;
import com.helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mBtnJump = (Button) findViewById(R.id.jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1
                Intent intent = new Intent(AActivity.this,BActivity.class);
                //Activity之间的数据传递是通过Bundle实现的
                Bundle bundle = new Bundle();
                bundle.putString("name", "MU");
                bundle.putInt("number", 20);
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent, 0);
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtil.showMsg(AActivity.this, data.getExtras().getString("title"));
    }
}