package com.fei.mylibsdemo.tabac.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fei.feilibs_1_0_0.net.glide.GlideLoader;
import com.fei.mylibsdemo.R;

import java.util.List;

/**
 * @author fei
 * @date on 2018/10/25 0025
 * @describe TODO :
 **/
public class PicShowAdapter extends RecyclerView.Adapter<PicShowAdapter.MyViewHolder>{

    private Context mContext;
    private List<String> data;
    private LayoutInflater mInflater;

    public PicShowAdapter(Context context, List<String> data){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void setData(List<String> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_showpic,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GlideLoader.loadImageWithLoading(data.get(position),holder.itemPic_pic_iv
                ,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView itemPic_pic_iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            if(null == itemPic_pic_iv){
                itemPic_pic_iv = itemView.findViewById(R.id.itemPic_pic_iv);
            }
        }
    }
}
