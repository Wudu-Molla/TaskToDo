package com.example.taskstodo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class SQLiteHelper extends SQLiteOpenHelper{

    public static final int version = 1;
    public static final String DB_NAME;
    public static final String TABLE_NAME = "tasks";
    public static final String ID = "id";
    public static final String TASK;
    public static final String END_DATE;
    public static final String IS_DONE;



    static {
        DB_NAME = "task.db";
        TASK = "task";
        END_DATE = "end_date";
        IS_DONE = "is_done";
    }

    public static String TABLE = "create table if not exists " + TABLE_NAME + " (" + ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + TASK +
       " TEXT, " + END_DATE +" TEXT, " + IS_DONE + " TEXT )";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sql_db) {
        sql_db.execSQL(TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sql_db, int i, int i1) {
    sql_db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
    }

}
