package com.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.R;

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.HorViewHolder> {

    private Context mContext;
    private OnItemClickerListener mListener;
    private OnItemLongClickListener mLListener;

    HorAdapter(Context context, OnItemClickerListener listener,OnItemLongClickListener llistener){
        this.mContext = context;
        this.mListener = listener;
        this.mLListener = llistener;
    }
    @NonNull
    @Override
    public HorAdapter.HorViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HorViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorAdapter.HorViewHolder  holder, int position) {
        holder.textView.setText("Ole On the Wheel!");

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

    class HorViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public HorViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickerListener{
        void OnClick(int position);
    }
    public interface OnItemLongClickListener{
        void OnLongClick(int position);
    }
}
