package com.example.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class dbmanager extends SQLiteOpenHelper {
    private  static final String dbname="dbcomp";
    public dbmanager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table tbl_comp(name text, address text, date date, complaint_type text, complaint text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry="DROP TABLE IF EXISTS complaint";
        db.execSQL(qry);
        onCreate(db);

    }
    public String addrecord(String name, String address, String date, String complaint_type,String complaint)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        cv.put("date",date);
        cv.put("complaint_type",complaint_type);
        cv.put("complaint",complaint);
      float res=  db.insert("tbl_comp",null,cv);
        if(res==-1)
            return "failed";
            else
                return "successful";
    }
    public Cursor readalldata()
{
    SQLiteDatabase db=this.getWritableDatabase();
    String qry="select * from tbl_comp";
    Cursor cursor=db.rawQuery(qry,null);
    return cursor;
}

}
