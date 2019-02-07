package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsListAdapter extends RecyclerView.Adapter<DetailsListAdapter.MyViewHolder> {

    private ArrayList<Detail> dataSet;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView age;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = (TextView) itemView.findViewById(R.id.name);
            this.age = (TextView) itemView.findViewById(R.id.age);
        }
    }

    public DetailsListAdapter(ArrayList<Detail> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        holder.name.setText(dataSet.get(listPosition).getName());
        holder.age.setText(String.valueOf(dataSet.get(listPosition).getAge()));

    }


    @Override
    public int getItemCount() {
        return dataSet.size();

    }

}