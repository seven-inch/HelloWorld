package com.helloworld.gridview;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.helloworld.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GridViewActivity extends AppCompatActivity {

    private GridView mGv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGv = (GridView) findViewById(R.id.gv);
        mGv.setAdapter(new MyGridAdapter(GridViewActivity.this));
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"点击 pos:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"长按 pos:"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
