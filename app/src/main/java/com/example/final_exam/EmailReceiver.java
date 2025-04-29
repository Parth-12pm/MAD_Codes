package com.example.final_exam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class EmailReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String from = intent.getStringExtra("from");
        String subject = intent.getStringExtra("subject");

        Toast.makeText(context, "New Email from " + from + ":" + subject, Toast.LENGTH_LONG).show();
    }
}