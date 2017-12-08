package com.jenish9599.android.broadcastreceiverdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jenishpatel on 08/12/17.
 */

public class Adeptor extends RecyclerView.Adapter<Adeptor.ViewHolder > {




    private ArrayList<IncomingNumbers> arrayList = new ArrayList<>();

    public Adeptor(ArrayList<IncomingNumbers> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.id.setText(Integer.toString(arrayList.get(position).getId()));
        holder.number.setText(arrayList.get(position).getNumber());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        TextView id ;
        TextView number ;
         public ViewHolder(View itemView) {
            super(itemView);


            id = (TextView)itemView.findViewById(R.id.text_ID);
            number  = (TextView)itemView.findViewById(R.id.txtNumber);

        }
    }
}
