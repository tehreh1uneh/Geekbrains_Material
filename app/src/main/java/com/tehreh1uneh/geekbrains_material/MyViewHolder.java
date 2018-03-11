package com.tehreh1uneh.geekbrains_material;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView description;
    private TextView containerIndex;
    private ArrayList<String> data;
    private View itemView;

    MyViewHolder(View itemView, ArrayList<String> data) {
        super(itemView);
        this.itemView = itemView;
        description = itemView.findViewById(R.id.my_item_text);
        containerIndex = itemView.findViewById(R.id.my_container_index);
        this.data = data;
    }

    @SuppressLint("SetTextI18n")
    void setContainerIndex(int index) {
        containerIndex.setText("This is container № " + index);
    }

    void bind(int listIndex) {
        itemView.setTag(listIndex);
        description.setText(data.get(listIndex));
    }

    int getItemIndex() {
        return (int) itemView.getTag();
    }
}
