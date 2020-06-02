package com.example.todolist.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.todolist.dao.ToDoDAO;
import com.example.todolist.database.ToDoDatabase;
import com.example.todolist.entity.ToDoEntity;

import java.util.List;

public class ToDoRepository {
    private ToDoDAO mToDoDAO;
    private LiveData<List<ToDoEntity>> mToDos;

    public ToDoRepository(Application application){
        ToDoDatabase db = ToDoDatabase.getInstance(application);
        mToDoDAO = db.toDoDAO();
        mToDos = mToDoDAO.getAllToDoLists();
    }

    public LiveData<List<ToDoEntity>> getAllToDos(){
        return mToDos;
    }

    public void insert(ToDoEntity todo){
        ToDoDatabase.databaseWriteExecutor.execute(() -> {
            mToDoDAO.insert(todo);
        });
    }
}
