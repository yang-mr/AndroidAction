package com.example.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Person> data  = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person("jack" + i, "19" + i);
            data.add(0, person);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        adapter.setmResId(R.layout.recycler_item);
        adapter.setmData(data);

        adapter.setmOnBindData(new RecyclerViewAdapter.OnBindData<Person>() {
            @Override
            public void bindData(RecyclerViewAdapter.ItemViewHolder viewHolder, Person o) {
                viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
                viewHolder.textView.setText(o.getName());
            }

//            @Override
//            public void bindData(RecyclerViewAdapter.ItemViewHolder viewHolder, Person t) {
//                viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
//                viewHolder.textView.setText(t.getName());
//            }
        });
        mRecyclerView.setAdapter(adapter);
    }
}
