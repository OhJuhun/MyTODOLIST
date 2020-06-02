package com.example.todolist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {
    // RecyclerView 의 ViewHolder 만든다.
    private final TextView tvMemoTitle;
    private final TextView tvMemoContent;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        tvMemoTitle = (TextView) itemView.findViewById(R.id.tvMemoTitle);
        tvMemoContent = (TextView) itemView.findViewById(R.id.tvMemoContent);
    }

    public void onBind(String title, String content) {
        tvMemoTitle.setText(title);
        tvMemoContent.setText(content);
    }
    // 실제 데이터들을 1:1 대응하여 각각의 내부뷰에 바인딩시킨다

}

