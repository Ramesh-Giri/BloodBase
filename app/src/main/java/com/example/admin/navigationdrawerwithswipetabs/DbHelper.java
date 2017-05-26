package com.example.admin.navigationdrawerwithswipetabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RameshGiri on 4/13/2017.
 */

public class DbHelper  extends SQLiteOpenHelper
{ public static final String DATABSE_NAME = "Donors.db";
    public static final String TABLE_Donors = "Details";
    public static final String TABLE_Posts = "UserPost";


    public DbHelper(Context context) {
        super(context, DATABSE_NAME, null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_Donors + " (id integer primary key,Fullname VARCHAR,Mobno VARCHAR,Address VARCHAR,Available VARCHAR,BloodGrp VARCHAR);");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_Posts + " (id integer primary key,Fullname VARCHAR,Mobno VARCHAR,Address VARCHAR,Post VARCHAR,Time VARCHAR);");



    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //drop older table if exist


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Donors);


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Posts);

        //create table again

        onCreate(db);
    }



    public boolean insertdetails(String Fullname, String Mobno, String Address, String Available, String Bloodgrp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contextvalue = new ContentValues();
        contextvalue.put("Fullname", Fullname);
        contextvalue.put("Mobno", Mobno);
        contextvalue.put("Address", Address);
        contextvalue.put("Available", Available);
        contextvalue.put("BloodGrp", Bloodgrp);


        db.insert(TABLE_Donors, null, contextvalue);
        return true;
    }

    public Cursor getdonordetail(String bloodgroup)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data=db.rawQuery("select * from " + TABLE_Donors + " where BloodGrp=" + "'"+bloodgroup+"'",null);
        return data;
    }



    public void deletedonor(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery("delete from " + TABLE_Donors + " where id=" + "'"+id+"'",null);

    }



    public boolean insertpost(String Fullname, String Mobno, String Address, String Post, String Time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contextvalue = new ContentValues();
        contextvalue.put("Fullname", Fullname);
        contextvalue.put("Mobno", Mobno);
        contextvalue.put("Address", Address);
        contextvalue.put("Post", Post);
        contextvalue.put("Time", Time);

        db.insert(TABLE_Posts, null, contextvalue);
        return true;
    }


    public Cursor getposts()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data=db.rawQuery("select * from " + TABLE_Posts ,null);
        return data;
    }

}

