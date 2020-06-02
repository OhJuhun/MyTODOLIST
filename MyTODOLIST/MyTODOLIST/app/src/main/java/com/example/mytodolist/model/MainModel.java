package com.example.mytodolist.model;

import android.os.AsyncTask;

import com.example.mytodolist.dao.TodoDao;
import com.example.mytodolist.database.TodoDatabase;
import com.example.mytodolist.entity.Todo;

public class MainModel {
    private String title;
    private String content;

    public MainModel(){

    }
    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

}
