package com.example.final_exam;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Send_email extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1;
    EmailReceiver em;
    IntentFilter IF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        b1 = findViewById(R.id.b1);

        em = new EmailReceiver();
        IF = new IntentFilter("andriod.intent.action.VIEW");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(Intent.ACTION_SEND);
                String email = e1.getText().toString();
                String subject = e2.getText().toString();
                String body = e3.getText().toString();

                in.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                in.putExtra(Intent.EXTRA_SUBJECT, subject);
                in.putExtra(Intent.EXTRA_TEXT, body);
                in.setType("message/rfc822");
                startActivity(Intent.createChooser(in, "choose"));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(em, IF);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(em);
    }
}
