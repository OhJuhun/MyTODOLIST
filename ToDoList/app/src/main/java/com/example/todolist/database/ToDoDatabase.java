package com.example.todolist.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todolist.dao.ToDoDAO;
import com.example.todolist.entity.ToDoEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ToDoEntity.class}, version = 1, exportSchema = false)
public abstract class ToDoDatabase extends RoomDatabase {
    public abstract ToDoDAO toDoDAO();

    private static volatile ToDoDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static ToDoDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (ToDoDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ToDoDatabase.class,"todolist").build();
                }
            }
        }
        return INSTANCE;
    }
}
