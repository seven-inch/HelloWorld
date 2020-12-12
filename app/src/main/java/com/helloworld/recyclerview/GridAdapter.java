package com.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private Context mContext;
    private OnItemClickerListener mListener;
    private OnItemLongClickListener mLListener;

    GridAdapter(Context context, OnItemClickerListener listener, OnItemLongClickListener llistener){
        this.mContext = context;
        this.mListener = listener;
        this.mLListener = llistener;
    }
    @NonNull
    @Override
    public GridAdapter.GridViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.GridViewHolder  holder, int position) {
        holder.textView.setText("GGMU!");

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
        return 80;
    }

    class GridViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickerListener{
        void OnClick(int position);
    }
    public interface OnItemLongClickListener{
        void OnLongClick(int position);
    }
}
