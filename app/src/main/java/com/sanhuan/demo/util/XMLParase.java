package com.sanhuan.demo.util;

import android.util.Xml;

import com.sanhuan.demo.model.User;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/31.
 */

public class XMLParase {

    /**
     * 解析评论xml信息
     *
     * @param inputStream
     * @return
     */
    public static ArrayList<User> paraseCommentInfors(InputStream inputStream) {
        ArrayList<User> list = new ArrayList<User>();
        XmlPullParser parser = Xml.newPullParser();
       L.c("开始解析ing.....");
        try {
            parser.setInput(inputStream, "UTF-8");
            int eventType = parser.getEventType();
            User info = new User();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:// 文档开始事件,可以进行数据初始化处理
                        break;
                    case XmlPullParser.START_TAG:// 开始元素事件
                        String name = parser.getName();
                        if (name.equalsIgnoreCase("User")) {
                            info = new User();
                        } else if (name.equalsIgnoreCase("UserID")) {
                            eventType = parser.next();
                            info.setUserID(parser.getText());
                        } else if (name.equalsIgnoreCase("DeptID")) {
                            eventType = parser.next();
                            info.setDeptID(parser.getText());
                        } else if (name.equalsIgnoreCase("BulletinTime")) {
                            eventType = parser.next();
                            info.setBulletinTime(parser.getText());
                        } else if (name.equalsIgnoreCase("PersonID")) {
                            eventType = parser.next();
                            info.setPersonID(parser.getText());
                        } else if (name.equalsIgnoreCase("loginNum")) {
                            eventType = parser.next();
                            info.setLoginNum(parser.getText());
                        } else if (name.equalsIgnoreCase("LoginDate")) {
                            eventType = parser.next();
                            info.setLoginDate(parser.getText());
                        } else if (name.equalsIgnoreCase("State")) {
                            eventType = parser.next();
                            info.setState(parser.getText());
                        } else if (name.equalsIgnoreCase("SystemID")) {
                            eventType = parser.next();
                            info.setSystemID(parser.getText());
                        } else if (name.equalsIgnoreCase("ICCode_Check")) {
                            eventType = parser.next();
                            info.setICCode_Check(parser.getText());
                        } else if (name.equalsIgnoreCase("HideMenu")) {
                            eventType = parser.next();
                            info.setHideMenu(parser.getText());
                        } else if (name.equalsIgnoreCase("WjPrice_Right")) {
                            eventType = parser.next();
                            info.setWjPrice_Right(parser.getText());
                        } else if (name.equalsIgnoreCase("OrderPriceRight")) {
                            eventType = parser.next();
                            info.setOrderPriceRight(parser.getText());
                        } else if (name.equalsIgnoreCase("PrinteRight")) {
                            eventType = parser.next();
                            info.setPrinteRight(parser.getText());
                        } else if (name.equalsIgnoreCase("FUser")) {
                            eventType = parser.next();
                            info.setFUser(parser.getText());
                        } else if (name.equalsIgnoreCase("FName")) {
                            eventType = parser.next();
                            info.setFName(parser.getText());
                        } else if (name.equalsIgnoreCase("Password")) {
                            eventType = parser.next();
                            info.setPassword(parser.getText());
                        } else if (name.equalsIgnoreCase("mobile_tel")) {
                            eventType = parser.next();
                            info.setMobile_tel(parser.getText());
                        } else if (name.equalsIgnoreCase("Fmemo")) {
                            eventType = parser.next();
                            info.setFmemo(parser.getText());
                        } else if (name.equalsIgnoreCase("loginmachine")) {
                            eventType = parser.next();
                            info.setLoginmachine(parser.getText());
                        }

                        break;
                    case XmlPullParser.END_TAG:// 结束元素事件
                        if (parser.getName().equalsIgnoreCase("User")) {

                            list.add(info);
                            info = null;
                        }
                        break;
                }
                eventType = parser.next();
            }
            inputStream.close();
        } catch (Exception e) {
            L.c("解析失败");
        }
        return list;
    }
}
