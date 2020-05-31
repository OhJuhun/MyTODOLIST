package com.example.mymemo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymemo.model.MainModel;

public class MainViewHolder extends RecyclerView.ViewHolder {
    // RecyclerView 의 ViewHolder 만든다.
    private TextView tvMemoTitle;
    private TextView tvMemoConent;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        tvMemoTitle = itemView.findViewById(R.id.tvMemoTitle);
        tvMemoConent = itemView.findViewById(R.id.tvMemoConent);

    }

    public void onBind(MainModel model) {
        tvMemoTitle.setText(model.getTitle());
        tvMemoConent.setText(model.getContent());
    }
    // 실제 데이터들을 1:1 대응하여 각각의 내부뷰에 바인딩시킨다

}

