package com.example.todolist;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.utils.AlertMessageDialog;
import com.example.todolist.view.MainActivity;

public class MainViewHolder extends RecyclerView.ViewHolder {
    // RecyclerView 의 ViewHolder 만든다.
    private final TextView tvMemoTitle;
    private final TextView tvMemoContent;
    private final TextView tvDate;
    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                AlertMessageDialog.getInstance().selectAlertMessage("선택","삭제 / 수정하시겠습니까?", v.getContext());
                return true;
            }
        });
        tvMemoTitle = (TextView) itemView.findViewById(R.id.tvMemoTitle);
        tvMemoContent = (TextView) itemView.findViewById(R.id.tvMemoContent);
        tvDate = (TextView) itemView.findViewById(R.id.tvDate);
    }

    public void onBind(String title, String content, String date) {
        tvMemoTitle.setText(title);
        tvMemoContent.setText(content);
        tvDate.setText(date.substring(0,4)+"/"+date.substring(4,6)+"/"+date.substring(6,8)+" "+date.substring(8,10)+":"+date.substring(10,12));
    }
    // 실제 데이터들을 1:1 대응하여 각각의 내부뷰에 바인딩시킨다

}

