package com.helloworld.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.helloworld.R;

public class HorRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvHor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);
        mRvHor = findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHor.addItemDecoration(new HorRecyclerViewActivity.MyDecoration());
        mRvHor.setLayoutManager(linearLayoutManager);
        mRvHor.setAdapter(new HorAdapter(HorRecyclerViewActivity.this, new HorAdapter.OnItemClickerListener() {
            @Override
            public void OnClick(int position) {
                Toast.makeText(HorRecyclerViewActivity.this, "点击..." + position, Toast.LENGTH_SHORT).show();
            }
        }, new HorAdapter.OnItemLongClickListener() {
            @Override
            public void OnLongClick(int position) {
                Toast.makeText(HorRecyclerViewActivity.this, "长按..." + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(getResources().getDimensionPixelOffset(R.dimen.divivderHeight),0,getResources().getDimensionPixelOffset(R.dimen.divivderHeight),0);
        }
    }
}