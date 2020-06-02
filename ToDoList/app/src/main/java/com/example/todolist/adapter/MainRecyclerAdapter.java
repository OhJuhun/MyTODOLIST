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
        } else {
            // Covers the case of data not being ready yet.
        }
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

//
//    ArrayList<MainModel> dataList = new ArrayList<MainModel>();
//
//    @NonNull
//    @Override
//    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        // item.xml 을 parent ViewGroup 위에 Inflate 시켜 새로운 View를 하나 만든다.
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memoitem,parent,false);
//
//        // 그리고, 이 view를 바탕으로 ItemViewHolder 객체 생성
//        return new MainViewHolder(view);
//    }
//
//    // ViewHolder 에 각각의 항목들을 바인딩시킨다.
//    @Override
//    public void onBindViewHolder(@NonNull MainViewHolder itemViewHolder, int position) {
//        itemViewHolder.onBind(dataList.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataList.size();
//    }
//
//    // Data 객체(아이템) 을 하나씩 추가시킨다.
//    public void addItem(MainModel model) {
//        dataList.add(model);
//    }

}