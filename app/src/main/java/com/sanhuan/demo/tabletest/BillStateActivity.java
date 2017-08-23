package com.sanhuan.demo.tabletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.sanhuan.demo.Adapter.BillStateListAdapter;
import com.sanhuan.demo.model.Report;
import com.sanhuan.demo.util.Constants;

import java.util.List;

public class BillStateActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    private List<Report> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_state);
        addActionBar();
        init();

    }

    private void init() {
        listView = (ListView) findViewById(R.id.bill_state_list);
        BillStateListAdapter billStateListAdapter = new BillStateListAdapter(this, list);
        listView.setAdapter(billStateListAdapter);

        textView1 = (TextView) findViewById(R.id.Applicant);
        checkBox1 = (CheckBox) findViewById(R.id.Applicant_check);

        textView2 = (TextView) findViewById(R.id.accounting);
        checkBox2 = (CheckBox) findViewById(R.id.accounting_check);

        textView3 = (TextView) findViewById(R.id.manager);
        checkBox3 = (CheckBox) findViewById(R.id.manager_check);

        textView4 = (TextView) findViewById(R.id.accounting2);
        checkBox4 = (CheckBox) findViewById(R.id.accounting2_check);

        textView5 = (TextView) findViewById(R.id.Chairman);
        checkBox5 = (CheckBox) findViewById(R.id.Chairman_check);

        textView6 = (TextView) findViewById(R.id.supervise);
        checkBox6 = (CheckBox) findViewById(R.id.supervise_check);

        textView7 = (TextView) findViewById(R.id.Finance);
        checkBox7 = (CheckBox) findViewById(R.id.Finance_check);


    }

    /**
     * 添加菜单栏刷新按钮
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, Constants.MENU_BILL_STATE, 0, getResources().getString(R.string.swipe));
        return true;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
            case Constants.MENU_BILL_STATE:
                //刷新

                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
