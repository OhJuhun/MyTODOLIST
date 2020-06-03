package com.example.todolist.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import com.example.todolist.utils.AlertMessageDialog;
import com.example.todolist.utils.Code;
import com.example.todolist.R;


public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    private static Button btnCancel;
    private static Button btnOK;

    private static EditText etContent;
    private static EditText etSubject;


    private static DatePicker dpDatePicker;
    private static TimePicker tpTimePicker;
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
        dpDatePicker = (DatePicker) findViewById(R.id.datePicker);
        tpTimePicker = (TimePicker) findViewById(R.id.timePicker);

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
    String setDateAsString(Integer year,Integer month, Integer day, Integer hour, Integer min){
        String ret = year.toString();
        ret+= month<10 ? "0"+month.toString() : month.toString();
        ret+=day<10 ? "0"+day.toString() : day.toString();
        ret+=hour<10 ? "0" +hour.toString() : hour.toString();
        ret+=min<10 ? "0" + min.toString() : min.toString();
        return ret;
    }
    private void actionOK(){
        String subject = etSubject.getText().toString();
        String content = etContent.getText().toString();

        Integer year = dpDatePicker.getYear();
        Integer month = dpDatePicker.getMonth();
        Integer day = dpDatePicker.getDayOfMonth();
        Integer hour = tpTimePicker.getCurrentHour();
        Integer min = tpTimePicker.getCurrentMinute();
        String date = setDateAsString(year,month,day,hour,min);

        if(!canBind(subject,content)) return;
        Bundle bundle = new Bundle();
        bundle.putString("subject",subject);
        bundle.putString("content",content);
        bundle.putString("date",date);

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
