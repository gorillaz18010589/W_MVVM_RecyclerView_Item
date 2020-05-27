package com.example.mvvm_api.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_api.Model.NicePlace;
import com.example.mvvm_api.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {
    List<NicePlace> mData;
    Context mContext;

    public MainRecyclerAdapter(List<NicePlace> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main,parent,false);
        MainViewHolder mainViewHolder = new MainViewHolder(view);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.txtMsg.setText(mData.get(position).getTitle());
//        Picasso.with(mContext)
//                .load(mData.get(position).getImageUrl())
//                .into(holder.cirImg);
        holder.cirImg.setImageResource(mData.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView cirImg;
        private TextView txtMsg;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            cirImg =  itemView.findViewById(R.id.cir_img);
            txtMsg = itemView.findViewById(R.id.txt_msg);
        }
    }
}
