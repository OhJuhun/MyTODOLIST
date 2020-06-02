package com.example.mytodolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytodolist.MainViewHolder;
import com.example.mytodolist.R;
import com.example.mytodolist.model.MainModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<MainViewHolder> {

    ArrayList<MainModel> dataList = new ArrayList<MainModel>();

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // item.xml 을 parent ViewGroup 위에 Inflate 시켜 새로운 View를 하나 만든다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memoitem,parent,false);

        // 그리고, 이 view를 바탕으로 ItemViewHolder 객체 생성
        return new MainViewHolder(view);
    }

    // ViewHolder 에 각각의 항목들을 바인딩시킨다.
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder itemViewHolder, int position) {
        itemViewHolder.onBind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // Data 객체(아이템) 을 하나씩 추가시킨다.
    public void addItem(MainModel model) {
        dataList.add(model);
    }

}