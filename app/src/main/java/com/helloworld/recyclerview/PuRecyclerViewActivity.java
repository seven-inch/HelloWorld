package com.helloworld.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.helloworld.R;
public class PuRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mRvPu = (RecyclerView) findViewById(R.id.rv_pu);
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvPu.addItemDecoration(new MyDecoration());

        mRvPu.setAdapter(new StaggeredGridAdapter(PuRecyclerViewActivity.this, new StaggeredGridAdapter.OnItemClickerListener() {
            @Override
            public void OnClick(int position) {
                Toast.makeText(PuRecyclerViewActivity.this,"点击..."+position,Toast.LENGTH_SHORT).show();
            }
        }, new StaggeredGridAdapter.OnItemLongClickListener() {
            @Override
            public void OnLongClick(int position) {
                Toast.makeText(PuRecyclerViewActivity.this,"长按..."+position,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelSize(R.dimen.divivderHeight2);
            outRect.set(gap,gap,gap,gap);
        }
    }

}