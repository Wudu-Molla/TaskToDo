package com.example.taskstodo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    SQLiteHelper sql;
    SQLiteDatabase sql_db;

    public DBManager(Context context) {
        this.sql = new SQLiteHelper(context);
    }

    public void openDB(){
        sql_db = sql.getWritableDatabase();
        sql_db = sql.getWritableDatabase();
    }

    public void closeDB(){
        sql.close();
    }

    public void insert(String task, String end_date, String is_done){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TASK, task);
        values.put(SQLiteHelper.END_DATE, end_date);
        values.put(SQLiteHelper.IS_DONE, is_done);
        sql_db.insert(SQLiteHelper.TABLE_NAME, null, values);
    }


    public Cursor getData(){
        return sql_db.rawQuery("select * from " + SQLiteHelper.TABLE_NAME, null);
    }

}
