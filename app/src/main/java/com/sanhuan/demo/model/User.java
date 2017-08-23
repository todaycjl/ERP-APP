package com.sanhuan.demo.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/31.
 */


public class User {
    int UserID;
    int DeptID;
    int BulletinTime;
    int PersonID;
    int loginNum;
    Timestamp LoginDate;
    Boolean State;
    Boolean SystemID;
    Boolean ICCode_Check;
    Boolean HideMenu;
    Boolean WjPrice_Right;
    Boolean OrderPriceRight;
    Boolean PrinteRight;
    String FUser;
    String FName;
    String Password;
    String mobile_tel;
    String Fmemo;
    String loginmachine;

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", DeptID=" + DeptID +
                ", BulletinTime=" + BulletinTime +
                ", PersonID=" + PersonID +
                ", loginNum=" + loginNum +
                ", LoginDate=" + LoginDate +
                ", State=" + State +
                ", SystemID=" + SystemID +
                ", ICCode_Check=" + ICCode_Check +
                ", HideMenu=" + HideMenu +
                ", WjPrice_Right=" + WjPrice_Right +
                ", OrderPriceRight=" + OrderPriceRight +
                ", PrinteRight=" + PrinteRight +
                ", FUser='" + FUser + '\'' +
                ", FName='" + FName + '\'' +
                ", Password='" + Password + '\'' +
                ", mobile_tel='" + mobile_tel + '\'' +
                ", Fmemo='" + Fmemo + '\'' +
                ", loginmachine='" + loginmachine + '\'' +
                '}';
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = Integer.parseInt(userID);
    }

    public int getDeptID() {
        return DeptID;
    }

    public void setDeptID(String deptID) {
        DeptID = Integer.parseInt(deptID);
    }

    public int getBulletinTime() {
        return BulletinTime;
    }

    public void setBulletinTime(String bulletinTime) {
        BulletinTime = Integer.parseInt(bulletinTime);
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = Integer.parseInt(personID);
    }

    public int getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = Integer.parseInt(loginNum);
    }

    public Timestamp getLoginDate() {
        return LoginDate;
    }

    public void setLoginDate(String loginDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        LoginDate = Timestamp.valueOf(time);
    }

    public Boolean getState() {
        return State;
    }

    public void setState(String state) {
        State = Boolean.valueOf(state);
    }

    public Boolean getSystemID() {
        return SystemID;
    }

    public void setSystemID(String systemID) {
        SystemID = Boolean.valueOf(systemID);
    }

    public Boolean getICCode_Check() {
        return ICCode_Check;
    }

    public void setICCode_Check(String ICCode_Check) {
        this.ICCode_Check = Boolean.valueOf(ICCode_Check);
    }

    public Boolean getHideMenu() {
        return HideMenu;
    }

    public void setHideMenu(String hideMenu) {
        HideMenu = Boolean.valueOf(hideMenu);
    }

    public Boolean getWjPrice_Right() {
        return WjPrice_Right;
    }

    public void setWjPrice_Right(String wjPrice_Right) {
        WjPrice_Right = Boolean.valueOf(wjPrice_Right);
    }

    public Boolean getOrderPriceRight() {
        return OrderPriceRight;
    }

    public void setOrderPriceRight(String orderPriceRight) {
        OrderPriceRight = Boolean.valueOf(orderPriceRight);
    }

    public Boolean getPrinteRight() {
        return PrinteRight;
    }

    public void setPrinteRight(String printeRight) {
        PrinteRight = Boolean.valueOf(printeRight);
    }

    public String getFUser() {
        return FUser;
    }

    public void setFUser(String FUser) {
        this.FUser = FUser;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMobile_tel() {
        return mobile_tel;
    }

    public void setMobile_tel(String mobile_tel) {
        this.mobile_tel = mobile_tel;
    }

    public String getFmemo() {
        return Fmemo;
    }

    public void setFmemo(String fmemo) {
        Fmemo = fmemo;
    }

    public String getLoginmachine() {
        return loginmachine;
    }

    public void setLoginmachine(String loginmachine) {
        this.loginmachine = loginmachine;
    }
}