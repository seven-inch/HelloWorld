package com.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.helloworld.util.ToastUtil;
import com.wxy.chinamapview.model.ProvinceModel;
import com.wxy.chinamapview.view.ChinaMapView;

public class MapActivity extends AppCompatActivity {
    private ChinaMapView mChinaMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mChinaMapView = (ChinaMapView) findViewById(R.id.cmv);
        mChinaMapView.setEnableScroll(false);
       /* for (ProvinceModel provinceModel: mChinaMapView.getChinaMapModel().getProvincesList()){
            provinceModel.setSelectBorderColor(Color.parseColor("#0000FF"));
        }
        mChinaMapView.notifyDataChanged();*/

        mChinaMapView.setOnProvinceClickLisener(new ChinaMapView.onProvinceClickLisener() {
            @Override
            public void onSelectProvince(String provinceName) {
                for (int i = 0; i < mChinaMapView.getChinaMapModel().getProvincesList().size(); i++){
                    /*ProvinceModel provinceModel = mChinaMapView.getChinaMapModel().getProvincesList().get(i);
                    if(provinceModel.getName() == provinceName){
                        provinceModel.setColor(Color.parseColor("#0000FF"));
                    }else{
                        provinceModel.setColor(Color.parseColor("#FFFFFF"));
                    }*/
                    ToastUtil.showMsg(MapActivity.this, provinceName);
                }
                mChinaMapView.notifyDataChanged();
                mChinaMapView.setEnableTouch(true);
            }
        });




    }
}