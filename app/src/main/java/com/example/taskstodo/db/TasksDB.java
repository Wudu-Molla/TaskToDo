package com.example.taskstodo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Tasks.class}, version = 1)
public abstract class TasksDB extends RoomDatabase {

    public abstract TaskDAO taskDAO();


    public static TasksDB INSTANCE = null;

    public static synchronized TasksDB getDatabase(Context context){

        if(INSTANCE==null){
            INSTANCE =  Room.databaseBuilder(context.getApplicationContext(),
                    TasksDB.class, "tasks_database").allowMainThreadQueries().build();

        }
        return INSTANCE;

    }


}
