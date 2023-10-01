package com.example.taskstodo.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDAO {

    @Query("SELECT * FROM tasks_table")
    List<Tasks> getTasks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Tasks tasks);

    @Delete
    void delete(Tasks tasks);

}


