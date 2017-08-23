package com.sanhuan.demo.tabletest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sanhuan.demo.Adapter.ListViewAdapter;
import com.sanhuan.demo.model.User;
import com.sanhuan.demo.util.Constants;
import com.sanhuan.demo.view.CustomHScrollView;
import com.sanhuan.demo.util.DBUtil;
import com.sanhuan.demo.util.L;

import java.util.ArrayList;
import java.util.List;

public class SeeBillActivity extends AppCompatActivity {


    private RelativeLayout mHead;//标题头
    private ListView mListView;
    private List<User> mDataList;
    private ListViewAdapter mAdapter;
    private int leftPos;//用于记录CustomHScrollView的初始位置
    private int topPos;
    CustomHScrollView mScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_bill);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        addActionBar();
        initView();
        initData();
    }

    /**
     * 添加返回按钮
     */
    private void addActionBar() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
        mScrollView = (CustomHScrollView) findViewById(R.id.h_scrollView);
        mHead = (RelativeLayout) findViewById(R.id.head_layout);

        TextView mTextView1 = (TextView) mHead.findViewById(R.id.textView_1);
        TextView mTextView2 = (TextView) mHead.findViewById(R.id.textView_2);
        TextView mTextView3 = (TextView) mHead.findViewById(R.id.textView_3);
        TextView mTextView4 = (TextView) mHead.findViewById(R.id.textView_4);
        TextView mTextView5 = (TextView) mHead.findViewById(R.id.textView_5);
        TextView mTextView6 = (TextView) mHead.findViewById(R.id.textView_6);
        TextView mTextView7 = (TextView) mHead.findViewById(R.id.textView_7);

        mTextView1.setText("UserID");
        mTextView2.setText("FUser");
        mTextView3.setText("FName");
        mTextView4.setText("Fmemo");
        mTextView5.setText("PersonID");
        mTextView6.setText("LoginDate");
        mTextView7.setText("PrinteRight");

        mHead.setBackgroundResource(R.color.colorAccent);
        mHead.setFocusable(true);
        mHead.setClickable(true);
        mHead.setOnTouchListener(new MyTouchLinstener());
        mListView.setOnTouchListener(new MyTouchLinstener());
    }

    private DBUtil mDBUtil;

    /**
     * 加载数据
     */
    private void initData() {
        mDBUtil = new DBUtil();
        mDBUtil.getAllInfo("selectAllUserInfor", myhandler);
        L.c("开始获取数据的程序");

    }

    final Handler myhandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                ArrayList<User> drrayList = (ArrayList<User>) msg.obj;
                if (drrayList != null && !drrayList.isEmpty()) {
                    String str = drrayList.toString();
                    L.c("线程执行完毕，发送来的数据为：" + str);
                    mDataList = new ArrayList<>();
                    mDataList = drrayList;

                }

                setData();

            }


        }
    };

    private void setData() {
        mAdapter = new ListViewAdapter(this, mDataList, mHead);
        mListView.setAdapter(mAdapter);
    }

    class MyTouchLinstener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            //当在表头和listView控件上touch时，将事件分发给 ScrollView
            HorizontalScrollView headSrcrollView = (HorizontalScrollView) mHead.findViewById(R.id.h_scrollView);
            headSrcrollView.onTouchEvent(arg1);
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, Constants.MENU_SEEBILL, 0, "刷新");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) //得到被点击的item的itemId
        {
            case Constants.MENU_SEEBILL: //对应的ID就是在add方法中所设定的Id
                initData();//刷新，重新加载数据
                mScrollView.smoothScrollTo(leftPos, topPos);//每次刷新数据都让CustomHScrollView回到初始位置，避免错乱
                if (mAdapter != null) {
                    mAdapter.notifyDataSetChanged();
                }
                return true;

            // back button
            case android.R.id.home:
                this.finish();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * 记录CustomHScrollView的初始位置
     *
     * @param l
     * @param t
     */
    public void setPosData(int l, int t) {
        this.leftPos = l;
        this.topPos = t;
    }
}
