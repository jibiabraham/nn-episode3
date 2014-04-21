package com.studio.nn.episode3.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.nn.episode3.app.R;
import com.studio.nn.episode3.models.PostItem;

import java.util.ArrayList;

/**
 * Created by jibi on 21/4/14.
 */
public class AllPostsAdapter extends BaseAdapter {
    Context context;
    ArrayList<PostItem> posts;

    public AllPostsAdapter(Context context, ArrayList<PostItem> posts){
        this.context = context;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return this.posts.size();
    }

    @Override
    public Object getItem(int position) {
        return this.posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the item view if null
        if(convertView == null){
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.post_item_all, null);
        }

        // Get references to items and set values
        ImageView dp = (ImageView) convertView.findViewById(R.id.dp);
        TextView moniker = (TextView) convertView.findViewById(R.id.moniker);
        TextView ts = (TextView) convertView.findViewById(R.id.ts);
        TextView content = (TextView) convertView.findViewById(R.id.content);

        return convertView;
    }
}
