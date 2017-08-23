package com.sanhuan.demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sanhuan.demo.model.Report;
import com.sanhuan.demo.tabletest.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */

public class BillStateListAdapter extends BaseAdapter {
    private Context context;
    private List<Report> list;

    public BillStateListAdapter(Context context, List<Report> list) {
        this.context = context;
        this.list = list;

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
        MyViewHolder myViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.two_text_layout, parent, false);
            myViewHolder = new MyViewHolder();
            myViewHolder.textView1 = (TextView) convertView.findViewById(R.id.text1);
            myViewHolder.textView2 = (TextView) convertView.findViewById(R.id.text2);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        Report report = list.get(position);


        return convertView;
    }

    class MyViewHolder {
        TextView textView1, textView2;
    }
}
