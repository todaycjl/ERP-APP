package com.sanhuan.demo.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.sanhuan.demo.tabletest.ApplyActivity;

/**
 * Created by Administrator on 2017/7/31.
 */

public class L {
    public static void c(String str) {
        Log.e("Chen", str);
    }

    /**
     * 消息框：short弹出
     *
     * @param context
     * @param str
     */
    public static void t(Context context, String str) {
        Toast.makeText(context, "click " + str, Toast.LENGTH_SHORT).show();
    }

    /**
     * 消息框：long弹出
     *
     * @param context
     * @param str
     */
    public static void tl(Context context, String str) {
        Toast.makeText(context, "long click " + str, Toast.LENGTH_LONG).show();
    }

    /**
     * 进度框弹出
     *
     * @param context
     * @param title
     * @param content
     * @return
     */
    public static ProgressDialog showDialog(Context context, String title, String content) {
        //创建ProgressDialog实例
        ProgressDialog dialog = new ProgressDialog(context);

        //给dialog设置常用属性
        dialog.setTitle(title);           //设置标题
        dialog.setMessage(content);       //设置说明文字
        dialog.setIndeterminate(false);   //设置进度条是否为不明确(来回旋转)
        dialog.setCanceledOnTouchOutside(true);//设置点击屏幕不消失
        dialog.setCancelable(true);       //设置进度条是否可以按退回键取消

        //设置dialog的显示透明度等
        Window wd = dialog.getWindow();   //获取屏幕管理器
        WindowManager.LayoutParams lp = wd.getAttributes();
        lp.alpha = 0.8f;                  //设置循环框的透明度
        wd.setAttributes(lp);             //设置弹出框的透明度
        wd.setGravity(Gravity.CENTER);    //设置水平居中

        //显示弹出dialog
        dialog.show();

        return dialog;

    }

    /**
     * 进度框消失
     *
     * @param dialog
     */
    public static void dismissDialog(ProgressDialog dialog) {
        dialog.dismiss();
    }

    /**
     * 图片显示框
     *
     * @param context
     * @param bitmap
     */
    public static void showImageDialog(Context context, Bitmap bitmap) {
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(imageView);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(700, 700);
    }
}
