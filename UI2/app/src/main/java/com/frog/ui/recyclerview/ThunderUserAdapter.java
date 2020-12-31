package com.frog.ui.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.frog.ui.R;
import com.frog.ui.User;
import com.frog.ui.Util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class ThunderUserAdapter extends RecyclerView.Adapter<ThunderUserAdapter.LinearViewHolder> {

    private Context context;
    private List<User> dataItems = new ArrayList<>();

    ThunderUserAdapter(Context context,List<User> dataItems){
        this.context   = context;
        this.dataItems = dataItems;
    }

    public int getDataItemsLen(){
        return dataItems.size();
    }

    @Override
    public ThunderUserAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.thunder_info,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ThunderUserAdapter.LinearViewHolder holder, int position) {

        Glide.with(context)
                    .load(dataItems.get(position).getImg())
                    .into(holder.mTvWechatImg);
        holder.itemView.setOnClickListener(v -> ToastUtil.showMsg(context, "这是" + position + "个图片"));
        holder.mTvName.setText(dataItems.get(position).getNickname());
        holder.mTvCash.setText(String.valueOf(dataItems.get(position).getCash()));
        holder.mTvCoin.setText(String.valueOf(dataItems.get(position).getCoin()));
        holder.mTvYid.setText(dataItems.get(position).getYid());
    }

    @Override
    public int getItemCount() {
        return getDataItemsLen();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView mTvWechatImg;
        private TextView mTvName,mTvCash,mTvCoin,mTvYid;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvWechatImg = itemView.findViewById(R.id.iv_img);
            mTvName = itemView.findViewById(R.id.tv_wechat_name);
            mTvCash = itemView.findViewById(R.id.tv_cash);
            mTvCoin = itemView.findViewById(R.id.tv_coin);
            mTvYid  = itemView.findViewById(R.id.tv_yid);
        }
    }
}
