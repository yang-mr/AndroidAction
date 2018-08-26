package com.yw.yw.action.view.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yw.yw.action.R;

import java.util.ArrayList;
import java.util.List;

/**
 Desc
    1. 解决图片闪的情况
    2.
    3.

    ref:
        http://blog.csdn.net/qq_23012315/article/details/50807224
 18-2-11:上午9:54
 Author jack
*/
public class RecyclerDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private Button mButton;
    RecyclerViewAdapter adapter;
    private List<String> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);

        recyclerView = findViewById(R.id.recyclerview);
        mButton = findViewById(R.id.bt_refresh);
        mButton.setOnClickListener(this);

        initRecyclerView();
    }

    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        // 处理图片一闪的情况

        mData = getTestData();
        adapter = new RecyclerViewAdapter(mData);
        recyclerView.setAdapter(adapter);
    }

    private List<String> getTestData() {
        List<String> list = new ArrayList<>();
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1665207864,746409922&fm=27&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2909352837,4034562327&fm=27&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2826151633,3148962855&fm=200&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=500808421,1575925585&fm=200&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=1776751002,2239493494&fm=27&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=222615259,2947254622&fm=27&gp=0.jpg");
        return list;
    }

    private List<String> getNewData() {
        List<String> list = new ArrayList<>();
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=524329843,3308417969&fm=27&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2207140705,1569528043&fm=27&gp=0.jpg");
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_refresh:
            /*adapter.setUrls(getNewData());
            adapter.notifyDataSetChanged();*/

            mData.remove(0);
            mData.add(0, "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=524329843,3308417969&fm=27&gp=0.jpg");
            adapter.notifyItemChanged(0);
            break;
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        private List<String> urls;

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }

        public RecyclerViewAdapter(List<String> urls) {
            this.urls = urls;
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.recyclerview_item, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {

            Glide.with(holder.itemView.getContext())
                    .load(urls.get(position))
                    .into(holder.imageView);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position, List<Object> payloads) {
            if (payloads.isEmpty()) {
                onBindViewHolder(holder, position);
            } else {
                super.onBindViewHolder(holder, position, payloads);
            }
        }

        @Override
        public int getItemCount() {
            return urls.size();
        }
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
