package com.example.taskstodo.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDAO {

    @Query("SELECT * FROM tasks_table")
    List<Tasks> getTasks();

    @Query("SELECT * FROM tasks_table WHERE uid=:id")
    List<Tasks> getTasksWithUid(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Tasks tasks);

    @Delete
    void delete(Tasks tasks);


    @Query("DELETE FROM tasks_table WHERE uid=:id")
    void deleteTask(int id);

    @Query("UPDATE tasks_table SET is_done=:isDone WHERE uid=:id")
    void update(int id, boolean isDone);


}


