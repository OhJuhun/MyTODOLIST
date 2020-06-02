package com.example.mytodolist.utils;

import android.app.Activity;
import android.app.AlertDialog;

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
}
