package com.tehreh1uneh.geekbrains_material;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int LIST_SIZE = 100;

    private int numberOfAddedItem = 0;
    private ArrayList<String> listData;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.my_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        fillListData();
        adapter = new MyAdapter(listData);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                if (direction == ItemTouchHelper.LEFT || direction == ItemTouchHelper.RIGHT) {
                    MyViewHolder holder = (MyViewHolder) viewHolder;
                    int elementIndex = holder.getItemIndex();
                    listData.remove(elementIndex);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        touchHelper.attachToRecyclerView(recyclerView);

        FloatingActionButton fab = findViewById(R.id.my_fab);
        fab.setOnClickListener(v -> addListElement());
    }

    private void fillListData() {
        listData = new ArrayList<>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; i++) {
            listData.add("My own item № " + i);
        }
    }

    private void addListElement() {
        listData.add("Added item № " + numberOfAddedItem++);
        adapter.notifyDataSetChanged();
    }
}
