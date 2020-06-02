package com.example.todolist.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.repository.ToDoRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private ToDoRepository repository;
    private LiveData<List<ToDoEntity>> allTodos;

    public MainViewModel (Application application){
        super(application);
        repository = new ToDoRepository(application);
        allTodos = repository.getAllToDos();
    }
    public LiveData<List<ToDoEntity>> getAllTodos(){
        return allTodos;
    }

    public void insert(ToDoEntity todo){
        repository.insert(todo);
    }
}
