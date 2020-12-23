package com.helloworld.fragment;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.helloworld.R;

public class ContainerActivity extends AppCompatActivity {
    private AFragment aFragment;
    //private BFragment bFragment;
    //private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        //Fragment详解（二）
        /*mBtnChange = findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
            }
        });*/

        //实例化AFragment
        aFragment = AFragment.newInstance("我是参数");
        //把AFragment添加到Activity中，记得调用commit
        getFragmentManager().beginTransaction().add(R.id.fl_container, aFragment,"a").commitAllowingStateLoss();
    }

}