package com.example.todolist.view;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.todolist.R;
import com.example.todolist.adapter.MainRecyclerAdapter;
import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.model.MainModel;
import com.example.todolist.utils.Code;
import com.example.todolist.utils.ToastMessage;
import com.example.todolist.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MainRecyclerAdapter adapter;
    static Button btnAdd;
    static Button btnModify;
    static Button btnDelete;
    private RecyclerView recyclerView;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // recyclerView1의  layoutManger 형식을 지정한다.
        inflateLayout();
        setRecyclerView();
        setButtonClickListeners();
    }

    private void setRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final MainRecyclerAdapter adapter = new MainRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));


        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getAllTodos().observe(this, new Observer<List<ToDoEntity>>() {
            @Override
            public void onChanged(@Nullable final List<ToDoEntity> todos) {
                // Update the cached copy of the words in the adapter.
                adapter.setTodos(todos);
            }
        });
    }
    private void inflateLayout(){
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnModify = (Button) findViewById(R.id.btnModify);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void setButtonClickListeners(){
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnModify.setOnClickListener(this);
    }

    private void startAddItemActivity(){
        Intent intent = new Intent(getApplicationContext(),AddItemActivity.class);
        startActivityForResult(intent, Code.addItemRequestCode.getValue());
    }

    private void addNewContent(String title, String content,String date){
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTitle(title);
        toDoEntity.setContent(content);
        toDoEntity.setDate(date);
        viewModel.insert(toDoEntity);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent){
        super.onActivityResult(requestCode, resultCode, resultIntent);
        if(requestCode==Code.addItemRequestCode.getValue() && resultCode==Code.addItemResponseCode.getValue()){
            Bundle result = resultIntent.getBundleExtra("bundle");
            addNewContent(result.getString("subject"),result.getString("content"),result.getString("date"));
            ToastMessage.getInstance().showMessage("목록에 추가되었습니다.",getApplicationContext());
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAdd:
                startAddItemActivity();
                break;
            case R.id.btnDelete:
                ToastMessage.getInstance().showMessage("삭제 버튼 클릭",getApplicationContext());
                break;
            case R.id.btnModify:
                ToastMessage.getInstance().showMessage("수정 버튼 클릭",getApplicationContext());
                break;
        }
    }
}
