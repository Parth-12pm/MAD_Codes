package com.example.final_exam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class smsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) return;

        Bundle bundle = intent.getExtras();
        if (bundle == null) return;

        Object[] pdus = (Object[]) bundle.get("pdus");
        if (pdus == null) return;

        for (Object pdu : pdus) {
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);
            String sender = sms.getOriginatingAddress();
            String message = sms.getMessageBody();
            Toast.makeText(context.getApplicationContext(), "Sms from : " + sender + "\n :" + message, Toast.LENGTH_LONG).show();
        }
    }
}