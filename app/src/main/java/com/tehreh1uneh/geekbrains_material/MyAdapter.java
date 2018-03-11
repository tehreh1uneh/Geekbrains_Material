package com.tehreh1uneh.geekbrains_material;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<String> listData;
    private int containerIndex = 0;

    public MyAdapter(ArrayList<String> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.item_recycler, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v, listData);
        viewHolder.setContainerIndex(containerIndex++);

        v.setOnLongClickListener((View.OnLongClickListener) view -> {
            listData.remove((int) view.getTag());
            notifyDataSetChanged();
            return true;
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
