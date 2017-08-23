package com.sanhuan.demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sanhuan.demo.model.User;
import com.sanhuan.demo.tabletest.R;
import com.sanhuan.demo.tabletest.SeeBillActivity;
import com.sanhuan.demo.view.CustomHScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hbh on 2017/3/15.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<User> mList = new ArrayList<User>();
    private LayoutInflater mInflater;
    private RelativeLayout mHead;
    private int n = 1;//标记变量

    public ListViewAdapter(Context context, List<User> list, RelativeLayout head) {
        this.mContext = context;
        this.mList = list;
        this.mHead = head;
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {

        return mList==null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup group) {
        MyViewHolder holder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.list_item, group, false);
            holder = new MyViewHolder();
            CustomHScrollView scrollView = (CustomHScrollView) view.findViewById(R.id.h_scrollView);
            holder.scrollView = scrollView;
            holder.mTextView1 = (TextView) view.findViewById(R.id.textView_1);
            holder.mTextView2 = (TextView) view.findViewById(R.id.textView_2);
            holder.mTextView3 = (TextView) view.findViewById(R.id.textView_3);
            holder.mTextView4 = (TextView) view.findViewById(R.id.textView_4);
            holder.mTextView5 = (TextView) view.findViewById(R.id.textView_5);
            holder.mTextView6 = (TextView) view.findViewById(R.id.textView_6);
            holder.mTextView7 = (TextView) view.findViewById(R.id.textView_7);

            CustomHScrollView headSrcrollView = (CustomHScrollView) mHead.findViewById(R.id.h_scrollView);

            headSrcrollView.AddOnScrollChangedListener(new OnScrollChangedListenerImp(scrollView));

            view.setTag(holder);
        } else {
            holder = (MyViewHolder) view.getTag();
        }

        holder.mTextView1.setText("" + mList.get(i).getUserID());
        holder.mTextView2.setText("" + mList.get(i).getFUser());
        holder.mTextView3.setText("" + mList.get(i).getFName());
        holder.mTextView4.setText("" + mList.get(i).getFmemo());
        holder.mTextView5.setText("" + mList.get(i).getPersonID());
        holder.mTextView6.setText("" + mList.get(i).getLoginDate());
        holder.mTextView7.setText("" + mList.get(i).getPrinteRight());

        return view;
    }

    class OnScrollChangedListenerImp implements CustomHScrollView.OnScrollChangedListener {
        CustomHScrollView mScrollViewArg;

        public OnScrollChangedListenerImp(CustomHScrollView scrollViewar) {
            mScrollViewArg = scrollViewar;
        }

        @Override
        public void onScrollChanged(int l, int t, int oldl, int oldt) {
            mScrollViewArg.smoothScrollTo(l, t);
            if (n == 1) {//记录滚动的起始位置，避免因刷新数据引起错乱
                new SeeBillActivity().setPosData(oldl, oldt);
            }
            n++;
        }
    }

    ;

    class MyViewHolder {
        TextView mTextView1;
        TextView mTextView2;
        TextView mTextView3;
        TextView mTextView4;
        TextView mTextView5;
        TextView mTextView6;
        TextView mTextView7;
        HorizontalScrollView scrollView;
    }
}
