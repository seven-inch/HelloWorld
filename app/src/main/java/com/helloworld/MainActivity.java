package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.helloworld.Event.EventActivity;
import com.helloworld.fragment.ContainerActivity;
import com.helloworld.jump.AActivity;

public class MainActivity extends AppCompatActivity {

   private Button mBtnUI;
   private Button mBtnLifeCycle;
   private Button mBtnJump;
   private Button mBtnFragment;
   private Button mBtnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = (Button) findViewById(R.id.btn_ui);
        mBtnLifeCycle = (Button) findViewById(R.id.btn_lifecycle);
        mBtnJump = (Button) findViewById(R.id.btn_jump);
        mBtnFragment = (Button) findViewById(R.id.btn_fragment);
        mBtnEvent = (Button) findViewById(R.id.btn_event);
        setLinsteners();
    }

    private void setLinsteners(){
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}