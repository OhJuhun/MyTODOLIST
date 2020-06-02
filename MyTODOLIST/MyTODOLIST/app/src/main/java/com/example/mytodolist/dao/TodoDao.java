package com.example.mytodolist.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mytodolist.entity.Todo;
import com.example.mytodolist.model.MainModel;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM Todo")
    LiveData<MainModel> getAll();

    @Insert
    void insert(Todo todo);

    @Update
    void update(Todo todo);

    @Delete
    void delete(Todo todo);
}
