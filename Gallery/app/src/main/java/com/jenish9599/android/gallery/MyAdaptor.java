package com.jenish9599.android.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by jenishpatel on 31/12/17.
 */

public class MyAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    ArrayList<ImageModel> data = new ArrayList<>();
    Context context;

    public MyAdaptor(ArrayList<ImageModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        RecyclerView.ViewHolder viewHolder = new MyItemHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                Glide.with(context).load(data.get(position).getUrl()).thumbnail(0.5f)
                .override(200,200)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(((MyItemHolder) holder).imageView);
        Log.i("TAG","img loading");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyItemHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyItemHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_img);
        }
    }
}
