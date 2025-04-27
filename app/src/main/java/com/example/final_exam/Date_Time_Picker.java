package com.example.final_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class Date_Time_Picker extends AppCompatActivity {

    Button b1;
    DatePicker d1;
    TimePicker t1;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);

        b1 = findViewById(R.id.b1);
        d1 = findViewById(R.id.d1);
        t1 = findViewById(R.id.t1);
        result = findViewById(R.id.result);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = d1.getDayOfMonth();
                int month = d1.getMonth() + 1;
                int year = d1.getYear();

                int min = t1.getMinute();
                int hr = t1.getHour();

                result.setText("Date : " + day + "/" + month + "/" + year + "\nTime : " + hr + ":" + min);
            }
        });

    }
}