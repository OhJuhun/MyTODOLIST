package com.example.todolist.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.todolist.entity.ToDoEntity;

import java.util.List;

@Dao
public interface ToDoDAO {

    @Insert
    void insert(ToDoEntity toDo);

    @Query("SELECT * FROM todoinfo")
    LiveData<List<ToDoEntity>> getAllToDoLists();
}
