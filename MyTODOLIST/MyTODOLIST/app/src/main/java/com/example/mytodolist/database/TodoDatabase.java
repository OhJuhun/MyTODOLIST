package com.example.mytodolist.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mytodolist.entity.Todo;

@Database(entities = {Todo.class}, version =  1)
public abstract class TodoDatabase extends RoomDatabase {
    //singleton db
    private static TodoDatabase INSTANCE;

    public abstract TodoDatabase TodoDatabase();

    public static TodoDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, TodoDatabase.class , "todo-db").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
