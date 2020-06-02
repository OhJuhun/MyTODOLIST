package com.example.mytodolist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytodolist.R;
import com.example.mytodolist.adapter.RecyclerAdapter;
import com.example.mytodolist.model.MainModel;
import com.example.mytodolist.utils.Code;
import com.example.mytodolist.utils.ToastMessage;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerAdapter adapter;
    static Button btnAdd;
    static Button btnModify;
    static Button btnDelete;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // recyclerView1의  layoutManger 형식을 지정한다.
        inflateLayout();
        setButtonClickListeners();
        setRecyclerView();

    }
    private void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
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
        MainModel data = new MainModel();
        Intent intent = new Intent(getApplicationContext(),AddItemActivity.class);
        System.out.println(Code.addItemRequestCode);
        Code c = Code.addItemRequestCode;

        startActivityForResult(intent, Code.addItemRequestCode.getValue());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent){
        if(requestCode==Code.addItemRequestCode.getValue() && resultCode==Code.addItemResponseCode.getValue()){
            MainModel data = new MainModel();
            Bundle result = resultIntent.getBundleExtra("bundle");

            String setTitle = result.getString("subject");
            String setContent = result.getString("content");

            data.setTitle(setTitle);
            data.setContent(setContent);
            adapter.addItem(data);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            //구분선 추가
            adapter.notifyDataSetChanged();
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
