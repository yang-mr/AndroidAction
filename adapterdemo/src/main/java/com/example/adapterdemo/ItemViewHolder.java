package com.example.adapterdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created on 2017/11/823:44.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;

    public ItemViewHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.imageview);
        textView = (TextView) itemView.findViewById(R.id.textview);
    }
}
