package com.example.adapterdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created on 2017/11/723:46.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class RecyclerViewAdapter<T> extends Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private int mResId;
    private OnBindData mOnBindData;
    private ArrayList<T> mData;
    private ViewHolder mViewHolder;

    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setmViewHolder(ViewHolder mViewHolder) {
        this.mViewHolder = mViewHolder;
    }

    public void setmResId(int mResId) {
        this.mResId = mResId;
    }

    public void setmData(ArrayList data) {
        this.mData = data;
    }

    public RecyclerViewAdapter(Context mContext, int resId, ArrayList data) {
        this.mContext = mContext;
        this.mResId = resId;
        this.mData = data;
    }

    public RecyclerViewAdapter(Context mContext, int resId) {
        this.mContext = mContext;
        this.mResId = resId;
    }

    public void setmOnBindData(OnBindData mOnBindData) {
        this.mOnBindData = mOnBindData;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(mContext).inflate(mResId, parent, false);
            ItemViewHolder item = new ItemViewHolder(view);
            return item;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_two, parent, false);
            return new TextViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            if (mOnBindData != null) {
                mOnBindData.bindData(((ItemViewHolder) holder), mData.get(position));
            }

        } else if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).tv.setText("我是类型二");
            ((TextViewHolder) holder).textView.setText("我是类型三");
        }
    }

    public interface OnBindData<T> {
       void bindData(ItemViewHolder viewHolder, T t);
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size() == 0 ? 0 : mData.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageview);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
