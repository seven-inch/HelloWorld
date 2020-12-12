package com.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.StaggeredGridViewHolder> {

    private Context mContext;
    private OnItemClickerListener mListener;
    private OnItemLongClickListener mLListener;

    StaggeredGridAdapter(Context context, OnItemClickerListener listener, OnItemLongClickListener llistener){
        this.mContext = context;
        this.mListener = listener;
        this.mLListener = llistener;
    }
    @NonNull
    @Override
    public StaggeredGridAdapter.StaggeredGridViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StaggeredGridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_recycler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.StaggeredGridViewHolder  holder, int position) {
        if(position % 2 != 0) {
            holder.imageView.setImageResource(R.drawable.image1);
        }else{
            holder.imageView.setImageResource(R.drawable.image2);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnClick(position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mLListener.OnLongClick(position);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class StaggeredGridViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public StaggeredGridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickerListener{
        void OnClick(int position);
    }
    public interface OnItemLongClickListener{
        void OnLongClick(int position);
    }
}
