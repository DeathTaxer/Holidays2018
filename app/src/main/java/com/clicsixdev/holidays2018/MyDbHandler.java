package com.clicsixdev.holidays2018;

/**
 * Created by aravind on 24-12-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by aravind on 19-12-2017.
 */

public class MyDbHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "holidaysDB";
    public static final String TABLE_HOLIDAYS = "holidays";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_HOLIDAYNAME = "holidayname";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_STATES = "states";

    public MyDbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_HOLIDAYS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HOLIDAYNAME + " TEXT, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_STATES + " TEXT "
                +");";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_HOLIDAYS);
        onCreate(db);
    }


    public void addHoliday(String name ,String date ,String states){
        ContentValues values = new ContentValues();
        values.put(COLUMN_HOLIDAYNAME,name);
        values.put(COLUMN_DATE,date);
        values.put(COLUMN_STATES,states);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_HOLIDAYS,null,values);
        db.close();
    }

    public List<Holiday> getHolidays(String month){

        List<Holiday> hlist= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_HOLIDAYS + " WHERE STRFTIME(\'%m\'," + COLUMN_DATE + ") =\'" + month + "\';";

        Cursor c = db.rawQuery(query,null);

        if(c != null){
            c.moveToFirst();

            while (!c.isAfterLast()) {
                String name = c.getString(c.getColumnIndex(COLUMN_HOLIDAYNAME));
                String d = c.getString(c.getColumnIndex(COLUMN_DATE));
                String s = c.getString(c.getColumnIndex(COLUMN_STATES));
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                // Log.v("id:",c.getString(c.getColumnIndex(COLUMN_ID)));



                Date date = null;
                try {
                    date = format.parse(d);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Calendar cal = new GregorianCalendar();
                cal.setTime(date);
                Holiday h = new Holiday(name ,cal ,s);

                hlist.add(h);

                c.moveToNext();




            }
            c.close();
        }
        db.close();

        return hlist;


    }


    public int getRows(){

        String countQuery = "SELECT * FROM " + TABLE_HOLIDAYS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        int cnt = cursor.getCount();
        return cnt;
    }





}

