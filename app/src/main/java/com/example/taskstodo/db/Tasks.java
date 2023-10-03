package com.example.taskstodo.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks_table")
public class Tasks {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "task")
    public String task;

    @ColumnInfo(name = "end_date")
    public String endDate;

    @ColumnInfo(name = "is_done")
    public boolean isDone;


    public Tasks(String task, String endDate, boolean isDone) {
        this.task = task;
        this.endDate = endDate;
        this.isDone = isDone;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getUid() {
        return uid;
    }
}



