package com.example.taskstodo.db;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface TaskDAO {

    @Query("SELECT * FROM tasks_table")
    List<Tasks> getTasks();

    @Insert
    void insert(Tasks tasks);

    @Delete
    void delete(Tasks tasks);

}


