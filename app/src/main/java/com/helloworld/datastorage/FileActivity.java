package com.helloworld.datastorage;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.helloworld.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave, mBtnShow;
    private TextView mTvContent;
    private final String mFilename = "text.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mEtName = (EditText) findViewById(R.id.et_name);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);

        OnClick onClick = new OnClick();
        mBtnSave.setOnClickListener(onClick);
        mBtnShow.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_save:
                    save(mEtName.getText().toString());
                    break;
                case R.id.btn_show:
                    mTvContent.setText(read());
                    break;
            }
        }
    }
    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            /*//内部存储
            fileOutputStream = openFileOutput(mFilename, MODE_PRIVATE);
            //内部存储end*/

            //外部存储
            //创建文件夹
            File dir = new File(Environment.getExternalStorageDirectory(),"MU");
            if(!dir.exists()){
                dir.mkdirs();
            }
            //创建文件
            File file = new File(dir, mFilename);
            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            //外部存储end

            fileOutputStream.write(content.getBytes());
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try {
            /*//内部存储
            fileInputStream = openFileInput(mFilename);
            //内部存储end*/
            //外部存储
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"MU",mFilename);
            fileInputStream = new FileInputStream(file);
            //外部存储end

            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while((len = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}