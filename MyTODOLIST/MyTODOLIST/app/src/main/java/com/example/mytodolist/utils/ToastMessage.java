package com.example.mytodolist.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastMessage {

    public static void showMessage(String msg, Context c){
        Toast.makeText(c,msg,Toast.LENGTH_LONG).show();
    }
}
