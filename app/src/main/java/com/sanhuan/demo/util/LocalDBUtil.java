package com.sanhuan.demo.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sanhuan.demo.Common.Common;
import com.sanhuan.demo.GetDate.GetBillType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */

public class LocalDBUtil {
    private static LocalDBUtil instance;
    private MyDbOpenHelper mHelper;
    private SQLiteDatabase mDb;
    private Context context;

    private LocalDBUtil(Context context) {
        this.context = context;
        mHelper = new MyDbOpenHelper(context);
        mDb = mHelper.getWritableDatabase();
    }

    public static LocalDBUtil getInstance(Context context) {
        if (instance == null) {
            instance = new LocalDBUtil(context);

        }
        return instance;
    }


    class MyDbOpenHelper extends SQLiteOpenHelper {
        private static final String Db_NAME = "SanHuan.db";
        private static final int VERSION = 1;

        public MyDbOpenHelper(Context context) {
            super(context, Db_NAME, null, VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //审批类型
            String sql_create_state = "CREATE TABLE b_billtype(BillID int NOT NULL,BillCode varchar  NOT NULL,BillName varchar  NOT NULL,FType varchar  NOT NULL)";
            db.execSQL(sql_create_state);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    /**
     * 插入审批类型
     */
    public void inserBillType() {
        if (Common.IF_INSERT_BILL_TYPE == 0) {

            mDb.beginTransaction();
            mDb.execSQL(GetBillType.get0);
            mDb.execSQL(GetBillType.get1);
            mDb.execSQL(GetBillType.get2);
            mDb.execSQL(GetBillType.get3);
            mDb.execSQL(GetBillType.get4);
            mDb.execSQL(GetBillType.get5);
            mDb.execSQL(GetBillType.get6);
            mDb.execSQL(GetBillType.get7);
            mDb.execSQL(GetBillType.get8);
            mDb.execSQL(GetBillType.get9);
            mDb.execSQL(GetBillType.get10);
            mDb.execSQL(GetBillType.get11);
            mDb.execSQL(GetBillType.get12);
            mDb.execSQL(GetBillType.get13);
            mDb.execSQL(GetBillType.get14);
            mDb.execSQL(GetBillType.get15);
            mDb.execSQL(GetBillType.get16);
            mDb.execSQL(GetBillType.get17);
            mDb.execSQL(GetBillType.get18);
            mDb.execSQL(GetBillType.get19);
            mDb.execSQL(GetBillType.get20);
            mDb.execSQL(GetBillType.get21);
            mDb.execSQL(GetBillType.get22);
            mDb.execSQL(GetBillType.get23);
            mDb.execSQL(GetBillType.get24);
            mDb.execSQL(GetBillType.get25);
            mDb.execSQL(GetBillType.get26);
            mDb.execSQL(GetBillType.get27);
            mDb.execSQL(GetBillType.get28);
            mDb.execSQL(GetBillType.get29);
            mDb.execSQL(GetBillType.get30);
            mDb.execSQL(GetBillType.get31);
            mDb.execSQL(GetBillType.get32);
            mDb.execSQL(GetBillType.get33);
            mDb.execSQL(GetBillType.get34);
            mDb.execSQL(GetBillType.get35);
            mDb.execSQL(GetBillType.get36);
            mDb.execSQL(GetBillType.get37);
            mDb.execSQL(GetBillType.get38);
            mDb.execSQL(GetBillType.get39);
            mDb.execSQL(GetBillType.get40);
            mDb.execSQL(GetBillType.get41);
            mDb.execSQL(GetBillType.get42);
            mDb.execSQL(GetBillType.get43);
            mDb.execSQL(GetBillType.get44);
            mDb.execSQL(GetBillType.get45);
            mDb.execSQL(GetBillType.get46);
            mDb.execSQL(GetBillType.get47);
            mDb.execSQL(GetBillType.get48);
            mDb.execSQL(GetBillType.get49);
            mDb.execSQL(GetBillType.get50);
            mDb.execSQL(GetBillType.get51);
            mDb.execSQL(GetBillType.get52);
            mDb.execSQL(GetBillType.get53);
            mDb.execSQL(GetBillType.get54);
            mDb.setTransactionSuccessful();
            mDb.endTransaction();
            Common.IF_INSERT_BILL_TYPE = 1;
        }
    }

    /**
     * 获取审批单大类型
     *
     * @return
     */
    public List<String> getBillTypeForFType() {
        List<String> result = new ArrayList<String>();
        String sql = "select FType from b_billtype  group by FType";
        Cursor c = mDb.rawQuery(sql, null);

        while (c.moveToNext()) {
            String r = c.getString(c.getColumnIndex("FType"));
            //    L.c("-----------------" + r);
            result.add(r);
        }

        c.close();
        return result;
    }

    /**
     * 根据选择的大类型获得具体类型名称、ID
     *
     * @param FType
     * @return
     */
    public List<String> getBillTypeForNameID(String FType) {

        String sql = "select * from b_billtype where FType=? group by BillID order by BillID asc";
        Cursor c = mDb.rawQuery(sql, new String[]{FType});
        List<String> list = new ArrayList<String>();
        while (c.moveToNext()) {
            String BillName = c.getString(c.getColumnIndex("BillName"));
            String BillID = c.getString(c.getColumnIndex("BillID"));
            list.add(BillName);
        }
        c.close();
        return list;
    }
}
