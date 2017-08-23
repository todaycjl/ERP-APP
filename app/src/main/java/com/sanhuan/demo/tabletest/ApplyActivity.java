package com.sanhuan.demo.tabletest;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.sanhuan.demo.util.Constants;
import com.sanhuan.demo.util.L;
import com.sanhuan.demo.util.LocalDBUtil;
import com.sanhuan.demo.view.MyScrollView;

import java.util.Calendar;
import java.util.List;

public class ApplyActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner mSpinner0, mSpinner1, mSpinner2, mSpinner3;
    private Button Button_select, mButton1;
    private List<String> list_FType, list_FType_Name_ID;
    private ArrayAdapter<String> adapter0, adapter1;
    private ProgressDialog mProgressDialog;
    private String select_FType;
    private EditText edit_reason, edit_money, edit_date, edit_remarks;
    private MyScrollView scrollView;
    public static final int CAMERA_ITEM = 0;
    public static final int PHOTO_ITEM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        LocalDBUtil.getInstance(this).inserBillType();
        init();
        addActionBar();
        L.c("Android O");
        setAdapter();
    }

    /**
     * 初始化控件
     */
    public void init() {
        edit_reason = (EditText) findViewById(R.id.edit_reason);
        edit_money = (EditText) findViewById(R.id.edit_money);
        edit_date = (EditText) findViewById(R.id.edit_date);
        edit_date.setOnClickListener(this);
        edit_date.setInputType(InputType.TYPE_NULL);
        edit_date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePickerDialog();
                }
            }
        });
        edit_remarks = (EditText) findViewById(R.id.edit_remarks);

        scrollView = (MyScrollView) findViewById(R.id.scrollView0);
        scrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
            @Override
            public void onScroll(int scrollY) {
                //滑动隐藏软键盘
                InputMethodManager input = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                input.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            }
        });
        mSpinner0 = (Spinner) findViewById(R.id.spinner0);
        mSpinner1 = (Spinner) findViewById(R.id.spinner1);
        mSpinner2 = (Spinner) findViewById(R.id.spinner2);
        mSpinner3 = (Spinner) findViewById(R.id.spinner3);
        mButton1 = (Button) findViewById(R.id.button2);
        mButton1.setOnClickListener(this);

        Button_select = (Button) findViewById(R.id.button1);
        Button_select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                mProgressDialog = L.showDialog(ApplyActivity.this, "请求中", "正在提交ing");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.obtainMessage(Constants.TEST, "GOOD").sendToTarget();
                    }
                }).start();
                break;
            case R.id.edit_date:
                showDatePickerDialog();
                break;
            case R.id.button1:
                showItemsAlertDialog();
                break;
        }
    }

    public void showItemsAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setItems(new String[]{"相册", "拍照"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CAMERA_ITEM:

                        break;
                    case PHOTO_ITEM:

                        break;
                }
            }
        });
        builder.show();
    }

    /**
     * 弹出日期选择器
     */
    public void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog dpd = new DatePickerDialog(ApplyActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edit_date.setText(year + "   /   " + month + "   /   " + dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == Constants.TEST) {
                L.dismissDialog(mProgressDialog);
                L.t(ApplyActivity.this, (String) msg.obj);
            }
        }
    };

    /**
     * 设置适配器
     */
    public void setAdapter() {
        //报表类型
        list_FType = LocalDBUtil.getInstance(this).getBillTypeForFType();
        adapter0 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list_FType);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner0.setAdapter(adapter0);
        mSpinner0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //     L.c("你点击选择的是list_FType：" + list_FType.get(position));
                select_FType = list_FType.get(position);
                list_FType_Name_ID = LocalDBUtil.getInstance(ApplyActivity.this).getBillTypeForNameID(select_FType);
                adapter1.clear();
                adapter1.addAll(list_FType_Name_ID);
                mSpinner1.setSelection(0);
                //     L.c("可以选择的第二个链表:"+list_FType_Name_ID.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //报表名称
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner1.setAdapter(adapter1);
        mSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //      L.c("你点击选择的是list_FType_Name_ID：" + list_FType_Name_ID.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
