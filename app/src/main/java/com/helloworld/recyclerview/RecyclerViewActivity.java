package com.helloworld.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.helloworld.MainActivity;
import com.helloworld.R;
public class RecyclerViewActivity extends AppCompatActivity {

    private Button mBtnLinear;
    private Button mBtnHor;
    private Button mBtnGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        mBtnLinear = (Button) findViewById(R.id.btn_linear);
        mBtnHor = (Button) findViewById(R.id.btn_hor);
        mBtnGrid = findViewById(R.id.btn_grid);
        /*
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        */
        setClickListener();
    }

    private void setClickListener(){
        OnClick onClick = new OnClick();
        mBtnLinear.setOnClickListener(onClick);
        mBtnHor.setOnClickListener(onClick);
        mBtnGrid.setOnClickListener(onClick);
    }


    private class OnClick implements  View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_linear:
                    intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                    break;
                case R.id.btn_hor:
                    intent = new Intent(RecyclerViewActivity.this, HorRecyclerViewActivity.class);
                    break;
                case R.id.btn_grid:
                    intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}