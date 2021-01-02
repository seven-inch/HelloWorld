package com.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.helloworld.R;


public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave, mBtnShow;
    private TextView mTvContent;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        mEtName = (EditText) findViewById(R.id.et_name);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mSharedPreferences = this.getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        OnClick onClick = new OnClick();
        mBtnSave.setOnClickListener(onClick);
        mBtnShow.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_save:
                    mEditor.putString("name", mEtName.getText().toString());
                    mEditor.apply();
                    break;
                case R.id.btn_show:
                    mTvContent.setText(mSharedPreferences.getString("name", ""));
                    break;
            }
        }
    }
}