package com.example.mytodolist.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastMessage {
    private static ToastMessage toastInstance = new ToastMessage();
    public static synchronized ToastMessage getInstance() {
        return toastInstance;
    }
    public void showMessage(String msg, Context context){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
