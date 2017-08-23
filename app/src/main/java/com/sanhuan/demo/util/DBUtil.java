package com.sanhuan.demo.util;


import android.os.Handler;
import android.os.Message;

import com.sanhuan.demo.model.User;

import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DBUtil {
    private ArrayList<String> arrayList1 = new ArrayList<String>();
    private ArrayList<String> arrayList2 = new ArrayList<String>();
    private ArrayList<User> ResultList = new ArrayList<User>();
    private HttpConnSoap Soap = new HttpConnSoap();

    public static Connection getConnection() {
        Connection con = null;
        try {
            //Class.forName("org.gjt.mm.mysql.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://192.168.0.106:3306/test?useUnicode=true&characterEncoding=UTF-8","root","initial");
        } catch (Exception e) {

        }
        return con;
    }

    public List<HashMap<String, String>> getAllInfo(final String sql, final Handler myHandler) {
        HashMap<String, String> tempHash = new HashMap<String, String>();
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        list.clear();
        if (arrayList1 != null) {
            arrayList1.clear();
        }
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (ResultList != null) {
            ResultList.clear();
        }


        list.add(tempHash);

        new Thread() {
            public void run() {
                //arrayList1 = Soap.GetWebServre("selectAllCargoInfor", arrayList1, arrayList2);
                InputStream inputStream = Soap.GetWebServre(sql, arrayList1, arrayList2);

                ResultList = XMLParase.paraseCommentInfors(inputStream);
                L.c("返回链表，解析出来为：" + ResultList.toString());
                Message msg = new Message();
                msg.what = 0x123;
                msg.obj = ResultList;
                myHandler.sendMessage(msg);
            }
        }.start();

        return list;
    }


}

