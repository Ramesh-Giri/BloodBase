package com.example.admin.navigationdrawerwithswipetabs;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.example.admin.navigationdrawerwithswipetabs.TabFragment.int_items;
import static java.security.AccessController.getContext;

/**
 * Created by Admin on 3/1/2017.
 */

public class MyAdapter  extends FragmentPagerAdapter {


    public MyAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Page01();
            case 1:
                return new Page02();
            case 2:
                return new Page03();



        }
        return null;
    }

    @Override
    public int getCount() {


        return int_items;
    }



    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "ASK";
            case 1:
               return "imp num";
            case 2:
               return "Tips";
        }

        return null;
    }


}
