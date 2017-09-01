package com.sanhuan.demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sanhuan.demo.tabletest.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */

public class AppListAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private LayoutInflater mInflater;

    public AppListAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fragment_item, parent, false);
            holder = new ViewHolder();
            holder.text_items = (TextView) convertView.findViewById(R.id.app_text_items);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text_items.setText(list.get(position));
        return convertView;
    }


    class ViewHolder {
        TextView text_items;
    }
}
