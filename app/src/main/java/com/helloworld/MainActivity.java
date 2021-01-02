package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.helloworld.Event.EventActivity;
import com.helloworld.broadcast.BroadActivity;
import com.helloworld.datastorage.DataStorageActivity;
import com.helloworld.fragment.ContainerActivity;
import com.helloworld.jump.AActivity;

public class MainActivity extends AppCompatActivity {

   private Button mBtnUI;
   private Button mBtnLifeCycle;
   private Button mBtnJump;
   private Button mBtnFragment;
   private Button mBtnEvent;
   private Button mBtnHandler;
   private Button mBtnData;
   private Button mBtnBroadcast;
   private Button mBtnObjectAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = (Button) findViewById(R.id.btn_ui);
        mBtnLifeCycle = (Button) findViewById(R.id.btn_lifecycle);
        mBtnJump = (Button) findViewById(R.id.btn_jump);
        mBtnFragment = (Button) findViewById(R.id.btn_fragment);
        mBtnEvent = (Button) findViewById(R.id.btn_event);
        mBtnHandler = (Button) findViewById(R.id.btn_handler);
        mBtnData = (Button) findViewById(R.id.btn_data);
        mBtnBroadcast = (Button) findViewById(R.id.btn_broadcast);
        mBtnObjectAnim = (Button) findViewById(R.id.btn_object);
        setLinsteners();

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    private void setLinsteners(){
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnHandler.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
        mBtnObjectAnim.setOnClickListener(onClick);
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
                case R.id.btn_handler:
                    intent = new Intent(MainActivity.this, HandlerActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;
                case R.id.btn_object:
                    intent = new Intent(MainActivity.this, ObjectAnimActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}