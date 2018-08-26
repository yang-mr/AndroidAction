package com.yw.yw.action.view.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.yw.yw.action.R;

import java.util.Arrays;
import java.util.List;

/**
 * ref :
 * https://blog.csdn.net/iispring/article/details/50967445
 */
public class ListDemoActivity extends AppCompatActivity {
    private ListView mListView;
    private MyListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo);

        mListView = findViewById(R.id.listview);
        mAdapter = new MyListAdapter(Arrays.asList("111", "2222"));
        mListView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
    }

    class MyListAdapter extends BaseAdapter {
        private List<String> data;

        public MyListAdapter(List<String> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // to do...
            return null;
        }
    }
}
