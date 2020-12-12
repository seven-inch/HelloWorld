package com.helloworld.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.helloworld.R;
public class GridRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = (RecyclerView) findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        mRvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickerListener() {
            @Override
            public void OnClick(int position) {
                Toast.makeText(GridRecyclerViewActivity.this,"点击..."+position,Toast.LENGTH_SHORT).show();
            }
        }, new GridAdapter.OnItemLongClickListener() {
            @Override
            public void OnLongClick(int position) {
                Toast.makeText(GridRecyclerViewActivity.this,"长按..."+position,Toast.LENGTH_SHORT).show();
            }
        }));
    }
}