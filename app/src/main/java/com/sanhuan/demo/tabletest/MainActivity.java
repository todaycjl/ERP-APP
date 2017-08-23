package com.sanhuan.demo.tabletest;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sanhuan.demo.fragment.AppFragment;
import com.sanhuan.demo.fragment.HomeFragment;
import com.sanhuan.demo.fragment.NewsFragment;
import com.sanhuan.demo.model.User;
import com.sanhuan.demo.util.DBUtil;
import com.sanhuan.demo.util.L;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private int CURRENT_INDEX = -1;


    private Fragment[] fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //      mDBUtil = new DBUtil();
        fragments = new Fragment[3];
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        showFragment(0);


    }


    /**
     * 显示碎片，隐藏之前的碎片
     *
     * @param index
     */
    private void showFragment(int index) {
        Fragment fragment = fragments[index];
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (CURRENT_INDEX != -1) {
            ft.hide(fragments[CURRENT_INDEX]);
        }
        if (fragment != null) {
            ft.show(fragment);
        } else {
            fragment = createFragment(index);
            ft.add(R.id.content, fragment);
            fragments[index] = fragment;
        }
        ft.commit();
        CURRENT_INDEX = index;
    }

    private Fragment createFragment(int index) {
        switch (index) {
            case 0:
                return new HomeFragment();
            case 1:
                return new AppFragment();
            case 2:
                return new NewsFragment();
        }
        return null;
    }

    /**
     * 底下按钮的监听
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(0);
                    return true;
                case R.id.navigation_dashboard:
                    showFragment(1);
                    return true;
                case R.id.navigation_notifications:
                    showFragment(2);
                    return true;
            }
            return false;
        }

    };


}
