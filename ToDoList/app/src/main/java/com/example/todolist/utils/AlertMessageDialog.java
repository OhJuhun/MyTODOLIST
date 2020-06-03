package com.example.todolist.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertMessageDialog {
    //버튼이 없는 alertmessage
    //왜 context로는 안되고 Activity로는 되지
    private static AlertMessageDialog alertInstance = new AlertMessageDialog();
    public static synchronized AlertMessageDialog getInstance() {
        return alertInstance;
    }
    public void simpleAlertMessage(String msgTitle, String msgContent, Activity activity){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        dialogBuilder.setTitle(msgTitle);
        dialogBuilder.setMessage(msgContent);
        dialogBuilder.show();
    }

    private static int flag=0;
    public void setFlag(int flag){
        this.flag = flag;
    }

    public int getFlag(){
        return flag;
    }
    public int selectAlertMessage(String title, String message, Context context){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        boolean flag = false;
        dialogBuilder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setFlag(1);
            }
        });
        dialogBuilder.setNeutralButton("수정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setFlag(2);
            }
        });
        dialogBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setFlag(0);
            }
        });
        dialogBuilder.show();
        return getFlag();
    }

}
