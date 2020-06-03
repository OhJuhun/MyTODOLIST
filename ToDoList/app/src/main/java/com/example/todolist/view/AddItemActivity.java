package com.example.todolist.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.todolist.utils.AlertMessageDialog;
import com.example.todolist.utils.Code;
import com.example.todolist.R;


public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    private static Button btnCancel;
    private static Button btnOK;

    private static EditText etContent;
    private static EditText etSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        inflateLayout();
        setButtonClickListeners();
    }

    private void inflateLayout(){
        setContentView(R.layout.activity_additem);

        btnCancel  = (Button) findViewById(R.id.btnOK);
        btnOK = (Button) findViewById(R.id.btnCancel);
        etSubject = (EditText) findViewById(R.id.etSubject);
        etContent = (EditText) findViewById(R.id.etContent);

    }
    private void setButtonClickListeners(){
        btnCancel.setOnClickListener(this);
        btnOK.setOnClickListener(this);
    }


    private boolean canBind(String subject, String content){
        if(subject.equals("")) {
            AlertMessageDialog.getInstance().simpleAlertMessage("제목이 없습니다.","제목을 입력해주세요.",this);
            return false;
        }
        if (content.equals("")) {
            AlertMessageDialog.getInstance().simpleAlertMessage("내용이 없습니다.","내용 입력해주세요.",this);
            return false;
        }
        return true;
    }

    private void actionOK(){
        String subject = etSubject.getText().toString();
        String content = etContent.getText().toString();

        if(!canBind(subject,content)) return;
        Bundle bundle = new Bundle();
        bundle.putString("subject",subject);
        bundle.putString("content",content);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("bundle",bundle);
        setResult(Code.addItemResponseCode.getValue(),resultIntent);
        finish();
    }

    private void actionCancel(){
        finish();
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnOK:
                actionOK();
                break;
            case R.id.btnCancel:
                actionCancel();
                break;

        }
    }
}
