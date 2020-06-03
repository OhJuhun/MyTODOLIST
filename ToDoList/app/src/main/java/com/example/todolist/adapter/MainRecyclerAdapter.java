package com.example.todolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.MainViewHolder;
import com.example.todolist.R;
import com.example.todolist.entity.ToDoEntity;
import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private final LayoutInflater inflater;
    private List<ToDoEntity> todos;
    public MainRecyclerAdapter (Context context){
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView = inflater.inflate(R.layout.todoitem, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        if (todos != null) {
            ToDoEntity current = todos.get(position);
            holder.onBind(current.getTitle(),current.getContent());
        }
        //todo가 널일 떄 ?
    }

    public void setTodos(List<ToDoEntity> todo){
        todos = todo;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (todos != null)
            return todos.size();
        else return 0;
    }
}