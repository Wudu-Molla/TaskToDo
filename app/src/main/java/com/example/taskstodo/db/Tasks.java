package com.example.taskstodo.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks_db")
public class Tasks {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "task")
    public String task;

    @ColumnInfo(name = "end_date")
    public String endDate;

    @ColumnInfo(name = "is_done")
    public boolean isDone;

}



