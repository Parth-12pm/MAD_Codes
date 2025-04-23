package com.example.final_exam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class Send_sms extends AppCompatActivity {

    Button b1;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        b1 = findViewById(R.id.b1);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);

        b1.setOnClickListener(v->{
            sendsms();
        });
    }
    public void sendsms(){

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
            String phone = e1.getText().toString();
            String msg = e2.getText().toString();
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phone,null,msg,null,null);
            Toast.makeText(this,"SMS sent",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"SMS Not sent",Toast.LENGTH_LONG).show();
        }
    }
}